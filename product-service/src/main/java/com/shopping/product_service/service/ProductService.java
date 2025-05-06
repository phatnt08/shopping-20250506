package com.shopping.product_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.shopping.product_service.dto.request.ProductRequest;
import com.shopping.product_service.dto.response.ApiResponse;
import com.shopping.product_service.mapper.ProductMapper;
import com.shopping.product_service.model.Product;
import com.shopping.product_service.repository.ProductRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductService {

    ProductRepository productRepository;

    ProductMapper productMapper;

    public ApiResponse<Boolean> addProduct(ProductRequest productRequest) {
        String id = UUID.randomUUID().toString();
        
        Product product = productMapper.toProdsuct(productRequest);
        product.setId(id);
        
        productRepository.save(product);

        return ApiResponse.<Boolean>builder()
                .result(true)
                .message("Product added successfully")
                .build();
        
    }

}
