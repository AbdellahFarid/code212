package com.code212.backend.repas;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/repas")
@RequiredArgsConstructor
public class RepasController {

    private final RepasService repasService;

    @PostMapping()
    public ResponseEntity<Repas> createRepas(@RequestBody Repas repas){

        return new ResponseEntity<>(repasService.createRepas(repas), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repas> getRepasById(@PathVariable Integer id){

        return ResponseEntity.ok(repasService.getRepastById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<Repas> getRepasByName(@RequestParam String name){

        return ResponseEntity.ok(repasService.getRepasByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<Repas>> getAllRepas(){

        return ResponseEntity.ok(repasService.getAllRepas());
    }

    @PutMapping("{id}")
    public ResponseEntity<Repas> editRepas(@PathVariable Integer id, @RequestBody Repas repas){

        return ResponseEntity.ok(repasService.updateRepas(id, repas));
    }

    @DeleteMapping("{id}")
    public void deleteRepas(@PathVariable Integer id){

        repasService.deleteRepas(id);
    }
}
