package com.code212.backend.restaurant;

import com.code212.backend.restaurant.dto.RestaurantRequest;
import com.code212.backend.restaurant.dto.RestaurantResponse;

import java.util.List;

public interface IRestaurantService {

    RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest);
    RestaurantResponse getRestaurantById(Integer id);
    RestaurantResponse getRestaurantByName(String name);
    List<RestaurantResponse> getAllRestaurants();
    RestaurantResponse updateRestaurant(Integer id, Restaurant updatedRestaurant);
    void deleteRestaurant(Integer id);
}
