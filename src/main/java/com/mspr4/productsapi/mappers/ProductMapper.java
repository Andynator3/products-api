package com.mspr4.productsapi.mappers;

import com.mspr4.productsapi.dtos.ProductDTO;
import com.mspr4.productsapi.entities.Product;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class ProductMapper {
    public ProductDTO fromProduct(Product product) {
        if (product == null) return null;
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        return productDTO;
    }

    public Product fromProductDTO(ProductDTO productDTO) {
        if (productDTO == null) return null;
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        return product;
    }
}

