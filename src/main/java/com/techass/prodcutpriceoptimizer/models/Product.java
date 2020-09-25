package com.techass.prodcutpriceoptimizer.models;

import javax.persistence.*;

@Entity
@Table(name="productlist")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id ;

    @Column(name="name")
    private  String name;

    @Column(name="upc")
    private  int unitsPerCarton;

    @Column(name="price")
    private  double cartonPrice;

    public Product() {
        super();
    }

    public Product( long id,  String name,  int unitsPerCarton,  double cartonPrice) {
        this.id = id;
        this.name = name;
        this.unitsPerCarton = unitsPerCarton;
        this.cartonPrice = cartonPrice;
    }



    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getUnitsPerCartoon() {
        return unitsPerCarton;
    }

    public double getCartonPrice() {
        return cartonPrice;
    }
}
