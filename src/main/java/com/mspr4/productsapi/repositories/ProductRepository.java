package com.mspr4.productsapi.repositories;

import com.mspr4.productsapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface ProductRepository extends JpaRepository<Product, Long> {

    }

