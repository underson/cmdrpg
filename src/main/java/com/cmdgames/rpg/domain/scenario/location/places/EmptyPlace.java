package com.cmdgames.rpg.domain.scenario.location.places;

import com.cmdgames.rpg.domain.characters.ElderThing;
import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.location.Place;

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
        // TODO also create a builder for the Player
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
