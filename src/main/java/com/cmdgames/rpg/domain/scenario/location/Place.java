package com.cmdgames.rpg.domain.scenario.location;

import com.cmdgames.rpg.domain.scenario.interactions.Battle;

import java.util.List;

public interface Place {

    public String getPlaceDescription();
    public String getPlaceAscii();
    public List<Battle> getPlaceEvents();

}
