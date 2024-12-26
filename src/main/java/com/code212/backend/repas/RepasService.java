package com.code212.backend.repas;

import com.code212.backend.restaurant.Restaurant;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RepasService {

    private final RepasRepository repasRepository;

    public Repas createRepas(Repas repas){

        Repas newRepas = new Repas();

        newRepas.setName(repas.getName());
        newRepas.setPrice(repas.getPrice());

        return repasRepository.save(newRepas);
    }

    public Repas getRepastById(Integer id){

        return repasRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Repas Not Found"));
    }

    public Repas getRepasByName(String name){

        return repasRepository.findByName(name).
                orElseThrow(() -> new EntityNotFoundException("Repas Not Found"));
    }

    public List<Repas> getAllRepas(){

        return repasRepository.findAll();
    }

    public Repas updateRepas(Integer id, Repas updatedRepas){

        Repas repas = repasRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Repas Not Found"));

        repas.setId(id);
        repas.setName(updatedRepas.getName());
        repas.setPrice(updatedRepas.getPrice());

        return repasRepository.save(repas);
    }

    public void deleteRepas(Integer id){
        repasRepository.deleteById(id);
    }
}
