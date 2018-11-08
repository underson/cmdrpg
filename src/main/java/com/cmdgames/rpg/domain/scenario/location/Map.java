package com.cmdgames.rpg.domain.scenario.location;

import com.cmdgames.rpg.domain.Player;
import com.cmdgames.rpg.domain.scenario.exception.NavigationNotAllowedException;

public abstract class Map {

    protected Location location;
    protected Player mainCharacter;
    protected Place [][] map;

    public Map(){
        location = new Location(1, 3);
        createMapLayout();
    }

    protected abstract Place[][] createMapLayout();

    public Place navigate(int command) throws NavigationNotAllowedException {
        PlaceWrapper wrapper = MapActions.navigate(command, this.location, this.map);
        this.location.setPositionX(wrapper.getPosX());
        this.location.setPositionY(wrapper.getPosY());
        return wrapper.getPlace();
    }

    public String getAllowedDirectionsMessage(){
        return MapActions.getAllowedDirectionsMessage(this.location);
    }

    public Player getMainCharacter() {
        return this.mainCharacter;
    }

}
