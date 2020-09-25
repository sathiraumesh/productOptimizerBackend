package com.techass.prodcutpriceoptimizer.services;

import com.techass.prodcutpriceoptimizer.models.Order;
import com.techass.prodcutpriceoptimizer.models.Product;
import com.techass.prodcutpriceoptimizer.models.ProductOrder;
import com.techass.prodcutpriceoptimizer.models.ProductPrice;
import com.techass.prodcutpriceoptimizer.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductService {

    @Autowired
    public final ProductRepository productRepository;

    private final double discount = 0.1;
    private final double manualLabourCostPercentage = 0.3;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(long id){
        return productRepository.findById(id);
    }

    public double getPrice(Order order){
        List<ProductOrder> productOrderList  = order.getOrder() ;

        double price=0;

        for (ProductOrder item:productOrderList) {

            Optional<Product> product = getProductById(item.getProductId());

            if(product.isPresent()){

                Product prod = product.get();
                price += calculatePriceOrderedUnits(prod.getUnitsPerCartoon(),prod.getCartonPrice(),item.getUnits());
                System.out.println(prod.getUnitsPerCartoon());

            }
        }
        return price;
    }


    public double calculatePriceOrderedUnits(int unitsPerCarton,double pricePerCarton,int orderedUnits){

        if(orderedUnits<=0||unitsPerCarton<=0||pricePerCarton<0){
            return 0;
        }

        double totalPrice =0;
        int cartons = orderedUnits/unitsPerCarton;
        int singleUnits = orderedUnits%unitsPerCarton;


        // calcualte carton price
        totalPrice+=cartons*pricePerCarton;

        // apply discounts

        if (cartons>=3){
            totalPrice = totalPrice- cartons*discount*pricePerCarton;
        }
        // calculate single unit price
        if(singleUnits>0){
            totalPrice =totalPrice+(pricePerCarton*manualLabourCostPercentage+pricePerCarton);
        }

        return totalPrice;
    }

    public List<ProductPrice> getProductPriceOnUnits(int units){

      List<Product> productList = getAllProducts();
      List<ProductPrice> productPriceList = new ArrayList<>();
        if (productList.size() > 0) {
            for (Product product:productList) {
           double price = calculatePriceOrderedUnits(product.getUnitsPerCartoon(),product.getCartonPrice(),units);
                ProductPrice temProdPrice = new ProductPrice(product.getId(),product.getName(),price);
                productPriceList.add(temProdPrice);
            }
        }
        return productPriceList;
        }


}
