package com.example.catalog.controller;

import com.example.catalog.entity.Catalog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatalogController {

    public ResponseEntity createCatalog(Catalog catalog);
    public ResponseEntity updateCatalog(Catalog catalog );
    public ResponseEntity deleteCatalog(String id);
    public ResponseEntity<Catalog> findCatalog(String id);
    public ResponseEntity<List<Catalog>> findAllCatalog();


}
