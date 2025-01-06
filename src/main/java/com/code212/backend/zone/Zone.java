package com.code212.backend.zone;

import com.code212.backend.restaurant.Restaurant;
import com.code212.backend.ville.Ville;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "zones")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "ville")
    private Ville ville;

    @OneToMany(mappedBy = "zone")
    private List<Restaurant> restaurants;
}
