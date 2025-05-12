package com.shopping.inventory_service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.shopping.inventory_service.dto.request.InventoryRequest;
import com.shopping.inventory_service.dto.response.InventoryResponse;
import com.shopping.inventory_service.model.Inventory;

@Mapper(componentModel = "spring")
public interface InventoryMapper {

    @Mapping(target = "id", ignore = true)
    Inventory toInventory(InventoryRequest request);

    InventoryResponse toInventoryResponse(Inventory inventory);

}
