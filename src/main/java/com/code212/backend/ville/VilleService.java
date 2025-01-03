package com.code212.backend.ville;

import com.code212.backend.specialite.Specialite;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VilleService {

    private final VilleRepository villeRepository;

    public Ville createVille(Ville Ville){

        Ville newVille = new Ville();

        newVille.setName(Ville.getName());

        return villeRepository.save(newVille);
    }

    public Ville getvilleById(Integer id){

        return villeRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Ville Not Found"));
    }

    public Ville getVilleByName(String name){

        return villeRepository.findByName(name).
                orElseThrow(() -> new EntityNotFoundException("Ville Not Found"));
    }

    public List<Ville> getAllVille(){

        return villeRepository.findAll();
    }

    public Ville updateVille(Integer id, Ville updatedVille){

        Ville ville = villeRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Ville Not Found"));

        ville.setId(id);
        ville.setName(updatedVille.getName());

        return villeRepository.save(ville);
    }

    public void deleteVille(Integer id){
        villeRepository.deleteById(id);
    }
}
