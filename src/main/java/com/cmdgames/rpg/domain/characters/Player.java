package com.cmdgames.rpg.domain.characters;

import com.cmdgames.rpg.repository.Persistable;

public class Player implements Persistable {

    private String name;
    private int age;
    private int strength; // takes more hits out of your opponents
    private int speed; // to be able to skip fights
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public Object getPersistableObject() {
        return this;
    }
}
