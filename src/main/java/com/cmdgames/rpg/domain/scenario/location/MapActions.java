package com.cmdgames.rpg.domain.scenario.location;

import com.cmdgames.rpg.domain.scenario.exception.NavigationNotAllowedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class MapActions {

    public static final int MOVE_UP = 1;
    public static final int MOVE_DOWN = 2;
    public static final int MOVE_LEFT = 3;
    public static final int MOVE_RIGHT = 4;

    private static final String MOVE_UP_MESSAGE = "1. Move Up\n";
    private static final String MOVE_DOWN_MESSAGE = "2. Move Down\n";
    private static final String MOVE_LEFT_MESSAGE = "3. Move Left\n";
    private static final String MOVE_RIGHT_MESSAGE = "4. Move Right\n";

    private static HashMap<Integer,String> allowedDirectionsMap = new HashMap<>();

    static {
        allowedDirectionsMap.put(MOVE_UP, MOVE_UP_MESSAGE);
        allowedDirectionsMap.put(MOVE_DOWN, MOVE_DOWN_MESSAGE);
        allowedDirectionsMap.put(MOVE_LEFT, MOVE_LEFT_MESSAGE);
        allowedDirectionsMap.put(MOVE_RIGHT, MOVE_RIGHT_MESSAGE);
    }

    private static List<Integer> getAllowedDirections(int currentPointX, int currentPointY){
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

    public static PlaceWrapper navigate(int direction, Location location, Place [][] map) throws NavigationNotAllowedException {

        validateNavigation(direction, location);

        switch (direction){
            case MOVE_UP:
                return navigateUp(map, location);
            case MOVE_DOWN:
                return navigateDown(map, location);
            case MOVE_LEFT:
                return navigateLeft(map, location);
            case MOVE_RIGHT:
                return navigateRight(map, location);
            default:
                return navigateTo(map, location);
        }
    }

    private static void  validateNavigation(int direction, Location location) throws NavigationNotAllowedException {
        if(!getAllowedDirections(location.getPositionX(), location.getPositionY()).contains(direction))
            throw new NavigationNotAllowedException();
    }

    public static String getAllowedDirectionsMessage(Location location){
        StringBuilder allowedDirectionsMessage = new StringBuilder();
        getAllowedDirections(location.getPositionX(), location.getPositionY()).forEach(
                allowedDirection -> allowedDirectionsMessage.append(allowedDirectionsMap.get(allowedDirection))
        );
        return allowedDirectionsMessage.toString();
    }

    private static PlaceWrapper navigateTo(Place [][] map, Location location){
        return new PlaceWrapper(map[location.getPositionY()][location.getPositionX()], location);
    }

    private static PlaceWrapper navigateLeft(Place [][] map, Location location){
        return new PlaceWrapper(map[location.getPositionY()][location.decrementAndGetPositionX()], location);
    }

    private static PlaceWrapper navigateRight(Place [][] map, Location location){
        return new PlaceWrapper(map[location.getPositionY()][location.incrementAndGetPositionX()], location);
    }

    private static PlaceWrapper navigateUp(Place [][] map, Location location){
        return new PlaceWrapper(map[location.decrementAndGetPositionY()][location.getPositionX()], location);
    }

    private static PlaceWrapper navigateDown(Place [][] map, Location location){
        return new PlaceWrapper(map[location.incrementAndGetPositionY()][location.getPositionX()], location);
    }


}
