package com.example.catalog.repository;

import com.example.catalog.entity.Catalog;
import org.springframework.data.repository.CrudRepository;

public interface CatalogRepository extends CrudRepository<Catalog, String> {


}
