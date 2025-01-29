package com.code212.backend.specialite;

import java.util.List;

public interface ISpecialiteService {

    Specialite createSpecialite(Specialite specialite);
    Specialite getspecialiteById(Integer id);
    Specialite getSpecialiteByName(String name);
    List<Specialite> getAllSpecialite();
    Specialite updateSpecialite(Integer id, Specialite updatedSpecialite);
    void deleteSpecialite(Integer id);
}
