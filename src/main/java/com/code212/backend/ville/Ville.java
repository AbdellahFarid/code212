package com.code212.backend.ville;

import com.code212.backend.zone.Zone;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@Entity
@Table(name = "villes")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Ville {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "ville")
    private List<Zone> zones;
}
