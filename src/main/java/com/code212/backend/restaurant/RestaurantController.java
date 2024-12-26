package com.code212.backend.restaurant;

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
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant){

        return new ResponseEntity<>(restaurantService.createRestaurant(restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable Integer id){

        return ResponseEntity.ok(restaurantService.getRestaurantById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<Restaurant> getRestaurantByName(@RequestParam String name){

        return ResponseEntity.ok(restaurantService.getRestaurantByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurants(){

        return ResponseEntity.ok(restaurantService.getAllRestaurants());
    }

    @PutMapping("{id}")
    public ResponseEntity<Restaurant> editRestaurant(@PathVariable Integer id, @RequestBody Restaurant restaurant){

        return ResponseEntity.ok(restaurantService.updateRestaurant(id, restaurant));
    }

    @DeleteMapping("{id}")
    public void deleteRestaurant(@PathVariable Integer id){

        restaurantService.deleteRestaurant(id);
    }

}
