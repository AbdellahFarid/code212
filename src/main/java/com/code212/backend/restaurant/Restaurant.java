package com.code212.backend.restaurant;

import com.code212.backend.repas.Repas;
import com.code212.backend.specialite.Specialite;
import com.code212.backend.zone.Zone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @CreationTimestamp
    private LocalDateTime dateCreation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST})
    @JoinColumn(name = "zone", nullable = false)
    private Zone zone;

    @OneToMany(mappedBy = "restaurant", cascade = { CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    private List<Repas> repas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "restaurant_specialite",
            joinColumns = @JoinColumn(name = "restaurant_id"),
            inverseJoinColumns = @JoinColumn(name = "specialite_id")
    )
    private List<Specialite> specialites;

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", dateCreation=" + dateCreation +
                ", zone=" + zone +
                ", repas=" + repas +
                ", specialites=" + specialites +
                '}';
    }
}
