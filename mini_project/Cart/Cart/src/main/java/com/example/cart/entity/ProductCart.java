package com.example.cart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Embeddable
public class ProductCart extends SuperEntity{

    @Id @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int productCartID;
    private String cart_id;
    private String product_id;
    private double productAmount;
    private double product_price;
    private double product_total_price;

}
