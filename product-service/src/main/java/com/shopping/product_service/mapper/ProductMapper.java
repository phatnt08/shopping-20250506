package com.shopping.product_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shopping.product_service.dto.request.ProductRequest;
import com.shopping.product_service.dto.response.ProductResponse;
import com.shopping.product_service.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "id", ignore = true)
    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);
}
