package com.code212.backend.zone;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ZoneServiceImpl implements IZoneService{

    private final ZoneRepository zoneRepository;

    public Zone createZone(Zone zone){

        return zoneRepository.save(zone);
    }

    public Zone getZoneById(Integer id){

        return zoneRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Zone Not Found"));
    }

    public Zone getZoneByName(String name){

        return zoneRepository.findByName(name).
                orElseThrow(() -> new EntityNotFoundException("Zone Not Found"));
    }

    public List<Zone> getAllZone(){

        return zoneRepository.findAll();
    }

    public Zone updateZone(Integer id, Zone updatedZone){

        Zone zone = zoneRepository.findById(id).
                orElseThrow(() -> new EntityNotFoundException("Zone Not Found"));

        zone.setId(id);
        zone.setName(updatedZone.getName());

        return zoneRepository.save(zone);
    }

    public void deleteZone(Integer id){
        zoneRepository.deleteById(id);
    }
}
