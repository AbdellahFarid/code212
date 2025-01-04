package com.code212.backend.restaurant.dto;

import lombok.Builder;

@Builder
public record RestaurantRequest(
        String name,
        Double latitude,
        Double longitude
) {
}
