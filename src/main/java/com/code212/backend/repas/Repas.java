package com.code212.backend.repas;

import com.code212.backend.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "repas")
@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class Repas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    @ManyToOne
    @JoinColumn(name = "restaurant")
    private Restaurant restaurant;
}
