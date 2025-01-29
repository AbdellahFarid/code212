package com.code212.backend.zone;

import java.util.List;

public interface IZoneService {

    Zone createZone(Zone zone);
    Zone getZoneById(Integer id);
    Zone getZoneByName(String name);
    List<Zone> getAllZone();
    Zone updateZone(Integer id, Zone updatedZone);
    void deleteZone(Integer id);
}
