package com.cmdgames.rpg.model.characters;

public class ElderOne extends Enemy {

    public ElderOne(int health, int strength, int speed){
        super(health, strength, speed, "Elder One");
    }

    @Override
    public String getEnemyMessage() {
        return  "@g#d$s%f&*!ºqª#e#s@!s$dA!da$!te#f";
    }
}