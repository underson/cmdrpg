package com.cmdgames.rpg.model.scenario.location;

import com.cmdgames.rpg.model.characters.ElderThing;
import com.cmdgames.rpg.model.scenario.interactions.Battle;

import java.util.ArrayList;
import java.util.List;

public class EmptyPlace implements Place {

    private String place;

    public EmptyPlace(String place){
        this.place = place;
    }

    @Override
    public String getPlaceDescription(){
        return this.place;
    }

    @Override
    public List<Battle> getPlaceEvents() {
        // Battle battle = FightFactory.getFight(FightType.ELDERTHING);
        // also create a builder for the Player
        List<Battle> events = new ArrayList<>();
        ElderThing elderThing = new ElderThing(100,100,50);
        Battle battle = new Battle(elderThing);
        events.add(battle);
        return events;
    }

    @Override
    public String getPlaceAscii() {
        return null;
    }
}
