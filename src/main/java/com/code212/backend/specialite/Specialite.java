package com.code212.backend.specialite;

import com.code212.backend.restaurant.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "specialite")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToMany(mappedBy = "specialites")
    private List<Restaurant> restaurants;
}
