package com.cmdgames.rpg.domain;

import com.cmdgames.rpg.repository.Persistable;

import java.io.Serializable;

public class Player implements Persistable, Serializable {

    private String name;
    private int strength;
    private int speed;
    private int health;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public Object getPersistableObject() {
        return this;
    }
}
