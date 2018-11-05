package com.cmdgames.rpg.model.scenario.exception;

public class NavigationNotAllowedException extends Exception {

    @Override
    public String getMessage() {
        return "You can´t go in that direction, choose one of the allowed options";
    }
}
