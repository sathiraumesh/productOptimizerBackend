package com.techass.prodcutpriceoptimizer.api;

import com.techass.prodcutpriceoptimizer.models.Order;
import com.techass.prodcutpriceoptimizer.models.Product;
import com.techass.prodcutpriceoptimizer.models.ProductOrder;
import com.techass.prodcutpriceoptimizer.models.ProductPrice;
import com.techass.prodcutpriceoptimizer.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    public final ProductService productService;



    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts(){
       return productService.getAllProducts();
    }

    @GetMapping(value="/price/{units}")
    public List<ProductPrice> getPriceProductsOnUnits(@PathVariable int units){
        return productService.getProductPriceOnUnits(units);
    }

    @PostMapping(value="/price")
    public double getPrice( @RequestBody Order order){

        return productService.getPrice(order);

    }
}
