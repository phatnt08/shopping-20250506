package com.shopping.order_service.service;

import org.springframework.stereotype.Service;

import com.shopping.order_service.dto.request.OrderRequest;
import com.shopping.order_service.dto.response.OrderResponse;
import com.shopping.order_service.mapper.OrderMapper;
import com.shopping.order_service.model.Order;
import com.shopping.order_service.repository.OrderRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderService {

    OrderRepository orderRepository;

    OrderMapper orderMapper;

    public OrderResponse createOrder(OrderRequest request) {
        Order order = orderMapper.toOrder(request);
        orderRepository.save(order);
        return orderMapper.toOrderResponse(order);
    }

}
