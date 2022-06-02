package com.example.catalog.Service.impl;

import com.example.catalog.Service.CatalogService;
import com.example.catalog.entity.Catalog;
import com.example.catalog.repository.CatalogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    private CatalogRepository catalogRepository;

    @Override
    public ResponseEntity create(Catalog catalog) {
        try {
            return new ResponseEntity<>(catalogRepository.save (catalog), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity update(Catalog catalog) {
        Optional<Catalog> categories  =  catalogRepository.findById(catalog.getCatalog_id());
        if(categories.isPresent())
            return new ResponseEntity<>( catalogRepository.save(catalog), HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity delete(String id) {
        try {
            catalogRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Catalog> find(String id) {
        Optional<Catalog> categories = catalogRepository.findById(id);
        if (categories.isPresent()) {
            return new ResponseEntity<>(categories.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<List<Catalog>> findAll() {
        try {
            List<Catalog> catalogsList = new ArrayList<Catalog>();
            catalogRepository.findAll().forEach(catalogsList::add);
            return new ResponseEntity<>(catalogsList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
