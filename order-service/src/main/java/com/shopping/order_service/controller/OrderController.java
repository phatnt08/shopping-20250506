package com.shopping.order_service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.order_service.dto.request.OrderRequest;
import com.shopping.order_service.dto.response.ApiResponse;
import com.shopping.order_service.dto.response.OrderResponse;
import com.shopping.order_service.service.OrderService;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class OrderController {

    OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<OrderResponse> placeOrder(@RequestBody OrderRequest request) {
        OrderResponse orderResponse = orderService.createOrder(request);

        return ApiResponse.<OrderResponse>builder()
                .code(HttpStatus.CREATED.value())
                .result(orderResponse)
                .build();
    }
}
