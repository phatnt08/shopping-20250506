package com.shopping.product_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.shopping.product_service.dto.request.ProductRequest;
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

    public void addProduct(ProductRequest productRequest) {
        String id = UUID.randomUUID().toString();
        
        
        
    }

}
