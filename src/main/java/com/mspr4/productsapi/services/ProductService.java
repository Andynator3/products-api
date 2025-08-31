package com.mspr4.productsapi.services;

import com.mspr4.productsapi.dtos.ProductDTO;

import java.util.List;

public interface ProductService {
    ProductDTO create(ProductDTO productDTO);
    ProductDTO update(Long id, ProductDTO productDTO);
    ProductDTO findById(Long id);
    List<ProductDTO> findAll();
    void delete(Long id);
}
