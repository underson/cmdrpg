package com.cmdgames.rpg.domain.scenario.location;

import com.cmdgames.rpg.repository.Persistable;

import java.io.Serializable;

public class Location implements Persistable, Serializable {

    private int positionX;
    private int positionY;

    public Location(int positionX, int positionY){
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int decrementAndGetPositionY() {
        return --positionY;
    }
    public int incrementAndGetPositionY() {
        return ++positionY;
    }
    public int decrementAndGetPositionX() {
        return --positionX;
    }
    public int incrementAndGetPositionX() {
        return ++positionX;
    }

    @Override
    public Object getPersistableObject() {
        return this;
    }
}
