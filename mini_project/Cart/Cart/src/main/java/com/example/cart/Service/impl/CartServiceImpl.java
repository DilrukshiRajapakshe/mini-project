package com.example.cart.Service.impl;

import com.example.cart.Service.CartService;
import com.example.cart.entity.Cart;
import com.example.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Override
    public ResponseEntity create(Cart cart) {
        try {
            return new ResponseEntity<>(cartRepository.save (cart), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity update(Cart cart) {
        Optional<Cart> categories  =  cartRepository.findById(cart.getCart_id());
        if(categories.isPresent())
            return new ResponseEntity<>( cartRepository.save(cart), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity delete(String id) {
        try {
            cartRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Cart> find(String id) {
        Optional<Cart> categories = cartRepository.findById(id);
        if (categories.isPresent()) {
            return new ResponseEntity<>(categories.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Cart>> findAll() {
        try {
            List<Cart> cartsList = new ArrayList<Cart>();
            cartRepository.findAll().forEach(cartsList::add);
            return new ResponseEntity<>(cartsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
