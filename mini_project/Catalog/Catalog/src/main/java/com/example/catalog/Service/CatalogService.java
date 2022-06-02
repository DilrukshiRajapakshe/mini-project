package com.example.catalog.Service;

import com.example.catalog.entity.Catalog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatalogService {

    public ResponseEntity create(Catalog catalog);
    public ResponseEntity update(Catalog catalog);
    public ResponseEntity delete(String id);
    public ResponseEntity<Catalog> find(String id);
    public ResponseEntity<List<Catalog>> findAll();

}
