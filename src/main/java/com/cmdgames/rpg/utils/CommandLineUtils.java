package com.cmdgames.rpg.utils;

import java.util.ArrayList;
import java.util.List;

public class CommandLineUtils {

    public static void print(String message){
        System.out.println(message);
    }

    public static List<String> isCommandValid(String command){
        List<String> errors = new ArrayList<>();
        if(command.isEmpty())
            errors.add("Command must not be empty\n");
        try {
            int option = Integer.valueOf(command);
            if(option < 1 || option > 4)
            errors.add("Command must be a number from 1 to 4");
        }catch (NumberFormatException ex){
            errors.add("The Command must be a number\n");
        }
        return errors;
    }
}
