package com.code212.backend.restaurant.dto;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.List;

@Builder
public record RestaurantResponse(
        Integer id,
        String name,
        Double latitude,
        Double longitude,
        LocalDateTime creationDate,
        String zone,
        List<String> meals

) {
}
