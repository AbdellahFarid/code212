package com.code212.backend.specialite;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialiteServiceImpl implements ISpecialiteService{

    private final SpecialiteRepository specialiteRepository;

    public Specialite createSpecialite(Specialite specialite){

        Specialite newSpecialite = new Specialite();

        newSpecialite.setName(specialite.getName());

        return specialiteRepository.save(newSpecialite);
    }

    public Specialite getspecialiteById(Integer id){

        return specialiteRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Repas Not Found"));
    }

    public Specialite getSpecialiteByName(String name){

        return specialiteRepository.findByName(name).
                orElseThrow(() -> new EntityNotFoundException("Repas Not Found"));
    }

    public List<Specialite> getAllSpecialite(){

        return specialiteRepository.findAll();
    }

    public Specialite updateSpecialite(Integer id, Specialite updatedSpecialite){

        Specialite specialite = specialiteRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Repas Not Found"));

        specialite.setId(id);
        specialite.setName(updatedSpecialite.getName());

        return specialiteRepository.save(specialite);
    }

    public void deleteSpecialite(Integer id){
        specialiteRepository.deleteById(id);
    }
}
