package com.example.cart.controller;

import com.example.cart.entity.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartController {

    public ResponseEntity createCart(Cart cart);
    public ResponseEntity updateCart(Cart cart );
    public ResponseEntity deleteCart(String id);
    public ResponseEntity<Cart> findCart(String id);
    public ResponseEntity<List<Cart>> findAllCart();


}
