package com.cmdgames.rpg.service;

import com.cmdgames.rpg.domain.scenario.exception.DataNotFoundException;
import com.cmdgames.rpg.domain.scenario.location.Location;
import com.cmdgames.rpg.repository.MapRepository;

import java.io.FileNotFoundException;

public class MapService {

    public Location retrieveSavedLocation() {
        MapRepository mapRepository = new MapRepository();
        Location location;
        try {
            location = (Location) mapRepository.retrieve();
        } catch (FileNotFoundException | DataNotFoundException ex) {
            return null;
        }
        return location;
    }

    public void saveLocation(Location location) {
        MapRepository mapRepository = new MapRepository();
        mapRepository.persist(location);
    }

}