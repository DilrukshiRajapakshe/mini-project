package com.example.product.controller.impl;

import com.example.product.Service.impl.ProductServiceImpl;
import com.example.product.controller.ProductController;
import com.example.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/product")
public class ProductControllerImpl implements ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @Override
    @PutMapping(value = "/{product_id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateProduct(@RequestBody Product product) {
        return productService.update(product);
    }

    @Override
    @DeleteMapping("/{product_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteProduct(@PathVariable String  product_id) {
        return productService.delete( product_id);
    }

    @Override
    @GetMapping("/{product_id}")
    public ResponseEntity<Product> findProduct(@PathVariable String  product_id) {
        return productService.find( product_id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Product>> findAllProduct() {
        return productService.findAll();
    }
}
