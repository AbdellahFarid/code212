package com.code212.backend.restaurant;

import com.code212.backend.repas.Repas;
import com.code212.backend.specialite.Specialite;
import com.code212.backend.zone.Zone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private Double latitude;
    private Double longitude;
    private LocalDateTime dateCreation;
    @ManyToOne
    @JoinColumn(name = "zone")
    private Zone zone;

    @OneToMany(mappedBy = "restaurant")
    private List<Repas> repas;

    @ManyToMany
    @JoinTable(
            name = "restaurant_specialite",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "specialite_id")
    )
    private List<Specialite> specialites;
}
