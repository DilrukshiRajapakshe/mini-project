package com.example.wishlist.controller.impl;

import com.example.wishlist.Service.impl.WishlistServiceImpl;
import com.example.wishlist.controller.WishlistController;
import com.example.wishlist.entity.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/wishlist")
public class WishlistControllerImpl implements WishlistController {

    @Autowired
    private WishlistServiceImpl wishlistService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.create(wishlist);
    }

    @Override
    @PutMapping(value = "/{wishlist_id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateWishlist(@RequestBody Wishlist wishlist) {
        return wishlistService.update(wishlist);
    }

    @Override
    @DeleteMapping("/{wishlist_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteWishlist(@PathVariable String  wishlist_id) {
        return wishlistService.delete( wishlist_id);
    }

    @Override
    @GetMapping("/{wishlist_id}")
    public ResponseEntity<Wishlist> findWishlist(@PathVariable String  wishlist_id) {
        return wishlistService.find( wishlist_id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Wishlist>> findAllWishlist() {
        return wishlistService.findAll();
    }
}
