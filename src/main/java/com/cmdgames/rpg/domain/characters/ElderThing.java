package com.cmdgames.rpg.domain.characters;

public class ElderThing extends Enemy {

    public ElderThing(int health, int strength, int speed){
        super(health, strength, speed, "Elder Thing");
    }

    @Override
    public String getEnemyMessage() {
        return  "@g#d$s%f&*!ºqª#e#s@!s$dA!da$!te#f";
    }
}