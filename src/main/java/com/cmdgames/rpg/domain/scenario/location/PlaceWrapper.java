package com.cmdgames.rpg.domain.scenario.location;

public class PlaceWrapper {

    private final Place place;
    private final int posX;
    private final int posY;

    public PlaceWrapper(Place place, Location location){
        this.place = place;
        this.posX = location.getPositionX();
        this.posY = location.getPositionY();
    }

    public Place getPlace() {
        return this.place;
    }
    public int getPosX() {
        return this.posX;
    }
    public int getPosY() {
        return this.posY;
    }

}
