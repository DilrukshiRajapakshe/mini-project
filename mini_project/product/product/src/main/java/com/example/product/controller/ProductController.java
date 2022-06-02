package com.example.product.controller;

import com.example.product.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductController {

    public ResponseEntity createProduct(Product product);
    public ResponseEntity updateProduct(Product product );
    public ResponseEntity deleteProduct(String id);
    public ResponseEntity<Product> findProduct(String id);
    public ResponseEntity<List<Product>> findAllProduct();


}
