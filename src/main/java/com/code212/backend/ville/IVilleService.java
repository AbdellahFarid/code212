package com.code212.backend.ville;

import java.util.List;

public interface IVilleService {

    Ville createVille(Ville Ville);
    Ville getvilleById(Integer id);
    Ville getVilleByName(String name);
    List<Ville> getAllVille();
    Ville updateVille(Integer id, Ville updatedVille);
    void deleteVille(Integer id);
}
