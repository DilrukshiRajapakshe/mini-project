package com.example.wishlist.Service;

import com.example.wishlist.entity.Wishlist;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface WishlistService {

    public ResponseEntity create(Wishlist wishlist);
    public ResponseEntity update(Wishlist wishlist );
    public ResponseEntity delete(String id);
    public ResponseEntity<Wishlist> find(String id);
    public ResponseEntity<List<Wishlist>> findAll();

}
