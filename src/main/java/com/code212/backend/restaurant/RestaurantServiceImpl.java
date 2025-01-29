package com.code212.backend.restaurant;

import com.code212.backend.repas.Repas;
import com.code212.backend.restaurant.dto.RestaurantRequest;
import com.code212.backend.restaurant.dto.RestaurantResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public RestaurantResponse createRestaurant(RestaurantRequest restaurantRequest){

        List<Repas> repasList = new ArrayList<>();

        Restaurant newRestaurant = restaurantMapper.toRestaurant(restaurantRequest);
        newRestaurant.setRepas(repasList);
        Restaurant savedRestaurant = restaurantRepository.save(newRestaurant);
        return restaurantMapper.toRestaurantResponse(savedRestaurant);
    }

    public RestaurantResponse getRestaurantById(Integer id){

        Restaurant restaurant = restaurantRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Restaurant Not Found"));
        return restaurantMapper.toRestaurantResponse(restaurant);
    }

    public RestaurantResponse getRestaurantByName(String name){

        Restaurant restaurant = restaurantRepository.findByNom(name).
                orElseThrow(() -> new EntityNotFoundException("Restaurant Not Found"));
        return restaurantMapper.toRestaurantResponse(restaurant);
    }

    public List<RestaurantResponse> getAllRestaurants(){

        return restaurantRepository.findAll()
                .stream()
                .map((restaurantMapper::toRestaurantResponse))
                .toList();
    }

    public RestaurantResponse updateRestaurant(Integer id, Restaurant updatedRestaurant){

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

        return restaurantMapper.toRestaurantResponse(restaurant);
    }

    public void deleteRestaurant(Integer id){
        restaurantRepository.deleteById(id);
    }
}
