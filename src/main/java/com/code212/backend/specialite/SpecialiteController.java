package com.code212.backend.specialite;

import com.code212.backend.repas.Repas;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/specialite")
public class SpecialiteController {

    private final SpecialiteService specialiteService;

    @PostMapping()
    public ResponseEntity<Specialite> createSpecialite(@RequestBody Specialite specialite){

        return new ResponseEntity<>(specialiteService.createSpecialite(specialite), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Specialite> getSpecialiteById(@PathVariable Integer id){

        return ResponseEntity.ok(specialiteService.getspecialiteById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<Specialite> getSpecialiteByName(@RequestParam String name){

        return ResponseEntity.ok(specialiteService.getSpecialiteByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<Specialite>> getAllSpecialite(){

        return ResponseEntity.ok(specialiteService.getAllSpecialite());
    }

    @PutMapping("{id}")
    public ResponseEntity<Specialite> editSpecialite(@PathVariable Integer id, @RequestBody Specialite specialite){

        return ResponseEntity.ok(specialiteService.updateSpecialite(id, specialite));
    }

    @DeleteMapping("{id}")
    public void deleteSpecialite(@PathVariable Integer id){

        specialiteService.deleteSpecialite(id);
    }
}
