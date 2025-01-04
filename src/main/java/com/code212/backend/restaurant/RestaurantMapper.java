package com.code212.backend.restaurant;

import com.code212.backend.restaurant.dto.RestaurantRequest;
import com.code212.backend.restaurant.dto.RestaurantResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RestaurantMapper {

    @Mapping(target = "nom", source = "name")
    Restaurant toRestaurant(RestaurantRequest restaurantRequest);

    @Mapping(target = "name", source = "nom")
    @Mapping(target = "creationDate", source = "dateCreation")
    RestaurantResponse toRestaurantResponse(Restaurant restaurant);
}
