package com.code212.backend.zone;


import com.code212.backend.specialite.Specialite;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @PostMapping()
    public ResponseEntity<Zone> createZone(@RequestBody Zone zone){

        return new ResponseEntity<>(zoneService.createZone(zone), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Zone> getZoneById(@PathVariable Integer id){

        return ResponseEntity.ok(zoneService.getZoneById(id));
    }

    @GetMapping("/find")
    public ResponseEntity<Zone> getZoneByName(@RequestParam String name){

        return ResponseEntity.ok(zoneService.getZoneByName(name));
    }

    @GetMapping()
    public ResponseEntity<List<Zone>> getAllZone(){

        return ResponseEntity.ok(zoneService.getAllZone());
    }

    @PutMapping("{id}")
    public ResponseEntity<Zone> editZone(@PathVariable Integer id, @RequestBody Zone zone){

        return ResponseEntity.ok(zoneService.updateZone(id, zone));
    }

    @DeleteMapping("{id}")
    public void deleteZone(@PathVariable Integer id){

        zoneService.deleteZone(id);
    }
}
