package com.example.catalog.controller.impl;

import com.example.catalog.Service.impl.CatalogServiceImpl;
import com.example.catalog.controller.CatalogController;
import com.example.catalog.entity.Catalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("api/v1/catalog")
public class CatalogControllerImpl implements CatalogController {

    @Autowired
    private CatalogServiceImpl catalogService;

    @Override
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createCatalog(@RequestBody Catalog Catalog) {
        return catalogService.create(Catalog);
    }

    @Override
    @PutMapping(value = "/{catalog_id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCatalog(@RequestBody Catalog Catalog) {
        return catalogService.update(Catalog);
    }

    @Override
    @DeleteMapping("/{catalog_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity deleteCatalog(@PathVariable String  Catalog_id) {
        return catalogService.delete( Catalog_id);
    }

    @Override
    @GetMapping("/{catalog_id}")
    public ResponseEntity<Catalog> findCatalog(@PathVariable String  Catalog_id) {
        return catalogService.find( Catalog_id);
    }

    @Override
    @GetMapping
    public ResponseEntity<List<Catalog>> findAllCatalog() {
        return catalogService.findAll();
    }
}
