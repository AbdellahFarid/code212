package com.code212.backend.ville;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/villes")
@RequiredArgsConstructor
public class VilleController {

    private final VilleService villeService;

    @PostMapping()
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville){

        return new ResponseEntity<>(villeService.createVille(ville), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable Integer id){

        return ResponseEntity.ok(villeService.getvilleById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<Ville> getVilleByName(@RequestParam String name){

        return ResponseEntity.ok(villeService.getVilleByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<Ville>> getAllVille(){

        return ResponseEntity.ok(villeService.getAllVille());
    }

    @PutMapping("{id}")
    public ResponseEntity<Ville> editVille(@PathVariable Integer id, @RequestBody Ville ville){

        return ResponseEntity.ok(villeService.updateVille(id, ville));
    }

    @DeleteMapping("{id}")
    public void deleteVille(@PathVariable Integer id){

        villeService.deleteVille(id);
    }
}
