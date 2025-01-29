package com.code212.backend.repas;

import java.util.List;

public interface IRepasService {

    Repas createRepas(Repas repas);
    Repas getRepastById(Integer id);
    Repas getRepasByName(String name);
    List<Repas> getAllRepas();
    Repas updateRepas(Integer id, Repas updatedRepas);
    void deleteRepas(Integer id);
}
