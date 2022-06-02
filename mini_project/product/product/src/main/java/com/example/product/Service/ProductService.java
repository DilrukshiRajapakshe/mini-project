package com.example.product.Service;

import com.example.product.entity.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {

    public ResponseEntity create(Product cart);
    public ResponseEntity update(Product cart );
    public ResponseEntity delete(String id);
    public ResponseEntity<Product> find(String id);
    public ResponseEntity<List<Product>> findAll();

}
