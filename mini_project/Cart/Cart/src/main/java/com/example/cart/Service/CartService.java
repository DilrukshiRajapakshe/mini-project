package com.example.cart.Service;

import com.example.cart.entity.Cart;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartService {

    public ResponseEntity create(Cart cart);
    public ResponseEntity update(Cart cart );
    public ResponseEntity delete(String id);
    public ResponseEntity<Cart> find(String id);
    public ResponseEntity<List<Cart>> findAll();

}
