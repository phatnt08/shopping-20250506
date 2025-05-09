package com.shopping.order_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shopping.order_service.dto.request.OrderRequest;
import com.shopping.order_service.dto.response.OrderResponse;
import com.shopping.order_service.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "id", ignore = true)
    Order toOrder(OrderRequest orderRequest);

    OrderResponse toOrderResponse(Order order);

}
