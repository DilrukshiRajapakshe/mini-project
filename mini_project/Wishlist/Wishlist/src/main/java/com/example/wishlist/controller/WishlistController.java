package com.example.wishlist.controller;

import com.example.wishlist.entity.Wishlist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WishlistController {

    public ResponseEntity createWishlist(Wishlist cart);
    public ResponseEntity updateWishlist(Wishlist cart );
    public ResponseEntity deleteWishlist(String id);
    public ResponseEntity<Wishlist> findWishlist(String id);
    public ResponseEntity<List<Wishlist>> findAllWishlist();


}
