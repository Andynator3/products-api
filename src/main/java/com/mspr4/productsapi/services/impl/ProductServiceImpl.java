package com.mspr4.productsapi.services.impl;

import com.mspr4.productsapi.dtos.ProductDTO;
import com.mspr4.productsapi.entities.Product;
import com.mspr4.productsapi.exceptions.ProductNotFoundException;
import com.mspr4.productsapi.mappers.ProductMapper;
import com.mspr4.productsapi.repositories.ProductRepository;
import com.mspr4.productsapi.services.ProductService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        Product product = productMapper.fromProductDTO(productDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.fromProduct(savedProduct);
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll().stream().map(productMapper::fromProduct).collect(Collectors.toList());
    }

    @Override
    public ProductDTO findById(Long id) {
        return productRepository.findById(id).map(productMapper::fromProduct)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    @Override
    public ProductDTO update(Long id, ProductDTO productDTO) {
        return productRepository.findById(id).map(product -> {
            product.setName(productDTO.getName());
            product.setDescription(productDTO.getDescription());
            product.setPrice(productDTO.getPrice());
            product.setStock(productDTO.getStock());
            return productMapper.fromProduct(productRepository.save(product));
        }).orElseThrow(() -> new ProductNotFoundException("Product not found with id " + id));
    }

    @Override
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ProductNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }


}
