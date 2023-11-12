package com.olidev.pe.manualspringdatajpaadvance.repository;

import com.olidev.pe.manualspringdatajpaadvance.domain.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
