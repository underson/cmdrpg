package com.cmdgames.rpg.model.characters;

public class Shoggoth extends Enemy {

    public Shoggoth(){
        super(1000,1000,10,"Shoggoth");
    }


    @Override
    public String getEnemyMessage() {
        return "eeeerrrrrrrrrtgggggggghhhhhhhh";
    }
}
