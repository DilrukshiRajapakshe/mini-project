package com.example.wishlist.repository;

import com.example.wishlist.entity.Wishlist;
import org.springframework.data.repository.CrudRepository;

public interface WishlistRepository extends CrudRepository<Wishlist, String> {


}
