package com.cmdgames.rpg.model.scenario.location;

import com.cmdgames.rpg.model.scenario.interactions.Battle;

import java.util.List;

public interface Place {

    public String getPlaceDescription();
    public String getPlaceAscii();
    public List<Battle> getPlaceEvents();

}
