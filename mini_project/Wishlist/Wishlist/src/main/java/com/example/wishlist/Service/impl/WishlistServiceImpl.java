package com.example.wishlist.Service.impl;

import com.example.wishlist.Service.WishlistService;
import com.example.wishlist.entity.Wishlist;
import com.example.wishlist.repository.WishlistRepository;
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
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Override
    public ResponseEntity create(Wishlist wishlist) {
        try {
            return new ResponseEntity<>(wishlistRepository.save (wishlist), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity update(Wishlist wishlist) {
        Optional<Wishlist> categories  =  wishlistRepository.findById(wishlist.getWishlist_id());
        if(categories.isPresent())
            return new ResponseEntity<>( wishlistRepository.save(wishlist), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity delete(String id) {
        try {
            wishlistRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Wishlist> find(String id) {
        Optional<Wishlist> categories = wishlistRepository.findById(id);
        if (categories.isPresent()) {
            return new ResponseEntity<>(categories.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Wishlist>> findAll() {
        try {
            List<Wishlist> WishlistsList = new ArrayList<Wishlist>();
            wishlistRepository.findAll().forEach(WishlistsList::add);
            return new ResponseEntity<>(WishlistsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
