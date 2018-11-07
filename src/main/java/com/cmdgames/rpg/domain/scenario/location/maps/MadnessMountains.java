package com.cmdgames.rpg.domain.scenario.location.maps;

import com.cmdgames.rpg.domain.characters.Player;
import com.cmdgames.rpg.domain.scenario.location.Map;
import com.cmdgames.rpg.domain.scenario.location.places.EmptyPlace;
import com.cmdgames.rpg.domain.scenario.location.Place;

public final class MadnessMountains extends Map {

    public MadnessMountains(Player mainCharacter){
        this.mainCharacter = mainCharacter;
    }

    protected Place[][] createMapLayout() {
        Place [][] map = {
                getFirstLevelMap(),
                getSecondLevelMap(),
                getThirdLevelMap(),
                getFourthLevelMap()
        };
        this.map = map;
        return map;
    }

    protected Place [] getFirstLevelMap(){
        Place [] lowerMap = {new EmptyPlace("00"), new EmptyPlace("10"), new EmptyPlace("20")};
        return lowerMap;
    }

    protected Place [] getSecondLevelMap(){
        Place [] lowerMap = {new EmptyPlace("01"), new EmptyPlace("11"), new EmptyPlace("21")};
        return lowerMap;
    }

    protected Place [] getThirdLevelMap(){
        Place [] lowerMap = {new EmptyPlace("02"), new EmptyPlace("12"), new EmptyPlace("22")};
        return lowerMap;
    }

    protected Place [] getFourthLevelMap(){
        Place [] lowerMap = {new EmptyPlace("03"), new EmptyPlace("13"), new EmptyPlace("23")};
        return lowerMap;
    }

}