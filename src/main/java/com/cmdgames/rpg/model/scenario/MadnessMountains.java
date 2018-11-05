package com.cmdgames.rpg.model.scenario;

import com.cmdgames.rpg.model.characters.Player;
import com.cmdgames.rpg.model.scenario.exception.NavigationNotAllowedException;
import com.cmdgames.rpg.model.scenario.location.EmptyPlace;
import com.cmdgames.rpg.model.scenario.location.Place;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MadnessMountains implements Map {

    private int currentPointY = 3;
    private int currentPointX = 1;

    public static final int MOVE_UP = 1;
    public static final int MOVE_DOWN = 2;
    public static final int MOVE_LEFT = 3;
    public static final int MOVE_RIGHT = 4;

    private static final String MOVE_UP_MESSAGE = "1. Move Up\n";
    private static final String MOVE_DOWN_MESSAGE = "2. Move Down\n";
    private static final String MOVE_LEFT_MESSAGE = "3. Move Left\n";
    private static final String MOVE_RIGHT_MESSAGE = "4. Move Right\n";

    private HashMap<Integer,String> allowedDirectionsMap = new HashMap<>();
    private Player mainCharacter;

    public MadnessMountains(Player mainCharacter){
        this.mainCharacter = mainCharacter;
        createMapLayout();
        this.allowedDirectionsMap.put(MOVE_UP, MOVE_UP_MESSAGE);
        this.allowedDirectionsMap.put(MOVE_DOWN, MOVE_DOWN_MESSAGE);
        this.allowedDirectionsMap.put(MOVE_LEFT, MOVE_LEFT_MESSAGE);
        this.allowedDirectionsMap.put(MOVE_RIGHT, MOVE_RIGHT_MESSAGE);
    }

    private Place [][] map;

    public Player getMainCharacter() {
        return mainCharacter;
    }

    private Place[][] createMapLayout() {
        Place [][] map =
                {
                        getFirstLevelMap(),
                        getSecondLevelMap(),
                        getThirdLevelMap(),
                        getFourthLevelMap()
                        };
        this.map = map;
        return map;
    }

    private Place navigateLeft(){
        return this.map[currentPointY][currentPointX = --currentPointX];
    }

    private Place navigateRight(){
        return this.map[currentPointY][currentPointX = ++currentPointX];
    }

    private Place navigateUp(){
        return this.map[currentPointY = --currentPointY][currentPointX];
    }

    private Place navigateDown(){
        return this.map[currentPointY = ++currentPointY][currentPointX];
    }



    private Place [] getFirstLevelMap(){
       Place [] lowerMap = {new EmptyPlace("Road to Old Town"), new EmptyPlace("Road to Old Town"), new EmptyPlace("Old Town")};
       return lowerMap;
    }

    private Place [] getSecondLevelMap(){
        Place [] lowerMap = {new EmptyPlace("Road to Old Town"), new EmptyPlace("Mountain Base"), new EmptyPlace("Cliff")};
        return lowerMap;
    }

    private Place [] getThirdLevelMap(){
        Place [] lowerMap = {new EmptyPlace("Cliffs"), new EmptyPlace("Base Road"), new EmptyPlace("Cliff")};
        return lowerMap;
    }

    private Place [] getFourthLevelMap(){
        Place [] lowerMap = {new EmptyPlace("Empty"), new EmptyPlace("Mountain Bottom"), new EmptyPlace("Empty")};
        return lowerMap;
    }

    public Place navigate(int direction) throws NavigationNotAllowedException {

        validateNavigation(direction);

        switch (direction){
            case MOVE_UP:
                return navigateUp();
            case MOVE_DOWN:
                return navigateDown();
            case MOVE_LEFT:
                return navigateLeft();
            case MOVE_RIGHT:
                return navigateRight();
            default:
                return navigateRight();// TODO return actual place
        }
    }

    private void validateNavigation(int direction) throws NavigationNotAllowedException {
        if(!getAllowedDirections().contains(direction))
            throw new NavigationNotAllowedException();
    }

    private List<Integer> getAllowedDirections(){
        List<Integer> directions = new ArrayList<>();
        if(currentPointY != 0)
            directions.add(MOVE_UP);
        if (currentPointY != 3)
            directions.add(MOVE_DOWN);
        if (currentPointX != 0)
            directions.add(MOVE_LEFT);
        if(currentPointX != 2)
            directions.add(MOVE_RIGHT);
        return directions;
    }

    public String getAllowedDirectionsMessage(){
        StringBuilder allowedDirectionsMessage = new StringBuilder();
        getAllowedDirections().forEach(
                allowedDirection -> allowedDirectionsMessage.append(allowedDirectionsMap.get(allowedDirection))
        );
        return allowedDirectionsMessage.toString();
    }
}