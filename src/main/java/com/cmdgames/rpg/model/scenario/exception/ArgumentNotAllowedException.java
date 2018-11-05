package com.cmdgames.rpg.model.scenario.exception;

public class ArgumentNotAllowedException extends Exception {
    @Override
    public String getMessage() {
        return "This option format is not allowed, choose one of the allowed below";
    }
}
