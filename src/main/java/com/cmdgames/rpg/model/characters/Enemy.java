package com.cmdgames.rpg.model.characters;

public abstract class Enemy {

    private int health;
    private int strength;
    private int speed;
    private String name;

    /**
     * Creates a new Enemy
     * @param health
     * @param strength
     * @param speed
     * @param name
     */
    public Enemy(int health, int strength, int speed, String name){
        this.health = health;
        this.strength = strength;
        this.speed = speed;
        this.name = name;
    }

    public abstract String getEnemyMessage();

    public final int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if(health < 0)
            health = 0;
        this.health = health;
    }

    public final int getStregth() {
        return this.strength;
    }

    public final int getSpeed() {
        return this.speed;
    }

    public final String getName() {
        return this.name;
    }
}
