package com.shopping.inventory_service.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.shopping.inventory_service.dto.request.InventoryRequest;
import com.shopping.inventory_service.dto.response.InventoryResponse;
import com.shopping.inventory_service.exception.AppException;
import com.shopping.inventory_service.mapper.InventoryMapper;
import com.shopping.inventory_service.model.Inventory;
import com.shopping.inventory_service.repository.InventoryRepository;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class InventoryService {

    InventoryRepository inventoryRepository;

    InventoryMapper inventoryMapper;

    public InventoryResponse createInventory(InventoryRequest request) {
        Inventory inventory = inventoryMapper.toInventory(request);
        inventoryRepository.save(inventory);
        return inventoryMapper.toInventoryResponse(inventory);
    }

    public InventoryResponse updateInventory(String id, InventoryRequest request) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new AppException(HttpStatus.BAD_REQUEST));

        inventory = inventoryMapper.toInventory(request);
        inventoryRepository.save(inventory);
        return inventoryMapper.toInventoryResponse(inventory);
    }

    public void deleteInventory(String id) {
        inventoryRepository.deleteById(id);
    }

    public List<InventoryResponse> getInventories() {
        List<Inventory> inventories = inventoryRepository.findAll();
        return inventories.stream().map(inventoryMapper::toInventoryResponse).toList();
    }

    public InventoryResponse getInventory(String id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new AppException(HttpStatus.NO_CONTENT));

        return inventoryMapper.toInventoryResponse(inventory);
    }

}
