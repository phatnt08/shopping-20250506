package com.shopping.inventory_service.grpc;

import org.springframework.grpc.server.service.GrpcService;

import io.grpc.stub.StreamObserver;

@GrpcService
public class InventoryGrpcService extends InventoryServiceGrpcGrpc.InventoryServiceGrpcImplBase {

    @Override
    public void createInventory(InventoryGrpcRequest request, StreamObserver<InventoryGrpcResponse> responseObserver) {
        // Implement the logic to create inventory using gRPC
        InventoryGrpcResponse response = InventoryGrpcResponse.newBuilder()
                .setId("1")
                .setSkuCode(request.getSkuCode())
                .setQuantity(request.getQuantity())
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
