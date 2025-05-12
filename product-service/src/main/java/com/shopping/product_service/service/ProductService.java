package com.shopping.product_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shopping.product_service.dto.request.ProductRequest;
import com.shopping.product_service.dto.response.ProductResponse;
import com.shopping.product_service.exception.AppException;
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
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductService {

    ProductRepository productRepository;

    ProductMapper productMapper;

    public ProductResponse createProduct(ProductRequest productRequest) {
        String id = UUID.randomUUID().toString();

        Product product = productMapper.toProduct(productRequest);
        product.setId(id);

        product = productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    public ProductResponse updateProduct(String id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(HttpStatus.BAD_REQUEST));

        product = productMapper.toProduct(request);
        product = productRepository.save(product);

        return productMapper.toProductResponse(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public List<ProductResponse> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::toProductResponse).toList();
    }

    public ProductResponse getProduct(String id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new AppException(HttpStatus.NO_CONTENT));
        return productMapper.toProductResponse(product);
    }

}
