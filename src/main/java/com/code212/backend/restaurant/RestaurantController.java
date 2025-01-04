package com.code212.backend.restaurant;

import com.code212.backend.restaurant.dto.RestaurantRequest;
import com.code212.backend.restaurant.dto.RestaurantResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/restaurants")
@RequiredArgsConstructor
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping()
    public ResponseEntity<RestaurantResponse> createRestaurant(@RequestBody RestaurantRequest restaurant){

        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantResponse> getRestaurantById(@PathVariable Integer id){

        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<RestaurantResponse> getRestaurantByName(@RequestParam String name){

        return ResponseEntity.ok(restaurantService.getRestaurantByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<RestaurantResponse>> getAllRestaurants(){

        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PutMapping("{id}")
    public ResponseEntity<RestaurantResponse> editRestaurant(@PathVariable Integer id, @RequestBody Restaurant restaurant){

        return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurant));
    }

    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable Integer id){

        restaurantService.deleteRestaurant(id);
    }

}
