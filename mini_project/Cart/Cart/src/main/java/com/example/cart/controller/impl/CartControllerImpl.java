package com.example.cart.controller.impl;

import com.example.cart.Service.impl.CartServiceImpl;
import com.example.cart.controller.CartController;
import com.example.cart.entity.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/cart")
public class CartControllerImpl implements CartController {

    @Autowired
    private CartServiceImpl cartService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCart(@RequestBody Cart cart) {
        return cartService.create(cart);
    }

    @Override
    @PutMapping(value = "/{ cart_id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCart(@RequestBody Cart cart) {
        return cartService.update(cart);
    }

    @Override
    @DeleteMapping("/{ cart_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteCart(@PathVariable String  cart_id) {
        return cartService.delete( cart_id);
    }

    @Override
    @GetMapping("/{ cart_id}")
    public ResponseEntity<Cart> findCart(@PathVariable String  cart_id) {
        return cartService.find( cart_id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Cart>> findAllCart() {
        return cartService.findAll();
    }
}
