package com.code212.backend.restaurant;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Restaurant createRestaurant(Restaurant restaurant){

        Restaurant newRestaurant = new Restaurant();

        newRestaurant.setNom(restaurant.getNom());
        newRestaurant.setLatitude(restaurant.getLatitude());
        newRestaurant.setLongitude(restaurant.getLongitude());
        newRestaurant.setDateCreation(LocalDateTime.now());

        return restaurantRepository.save(newRestaurant);
    }

    public Restaurant getRestaurantById(Integer id){

        return restaurantRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Restaurant Not Found"));
    }

    public Restaurant getRestaurantByName(String name){

        return restaurantRepository.findByNom(name).
                orElseThrow(() -> new EntityNotFoundException("Restaurant Not Found"));
    }

    public List<Restaurant> getAllRestaurants(){

        return restaurantRepository.findAll();
    }

    public Restaurant updateRestaurant(Integer id, Restaurant updatedRestaurant){

        Restaurant restaurant = restaurantRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Restaurant Not Found"));

        restaurant.setId(id);
        restaurant.setNom(updatedRestaurant.getNom());
        restaurant.setLongitude(updatedRestaurant.getLongitude());
        restaurant.setLatitude(updatedRestaurant.getLatitude());

        if (updatedRestaurant.getDateCreation() == null){
            restaurant.setDateCreation(restaurant.getDateCreation());
        } else {
            restaurant.setDateCreation(updatedRestaurant.getDateCreation());
        }

        return restaurantRepository.save(restaurant);
    }

    public void deleteRestaurant(Integer id){
        restaurantRepository.deleteById(id);
    }
}
