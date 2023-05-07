package com.ugurukku.rentalmvc.dtos;

public record CarRequest(
        String name,
        Integer productionYear,
        Integer categoryId
) {
}
