package com.cmdgames.rpg.front;

import com.cmdgames.rpg.utils.CommandLineUtils;

import java.util.Scanner;

public class CommandPanel {


    public static int getStartPanelOption() {
        boolean isValid = false;
        String command = null;

        while (!isValid) {
            CommandLineUtils.print("Do you want to restart the game or continue the existing?");
            CommandLineUtils.print("1. Continue ");
            CommandLineUtils.print("2. Start new game ");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            isValid = isStartOptionValid(command);
            if(!isValid)
                CommandLineUtils.print("Choose one of the options below:");
        }
        return Integer.valueOf(command);
    }

    public static String getPlayerName() {
        boolean isValid = false;
        String command = null;

        while (!isValid) {
            CommandLineUtils.print(" What's your name ?");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            isValid = isStringValid(command);
            if(!isValid)
                CommandLineUtils.print("Type your name below");
        }
        return command;
    }

    protected static boolean isStringValid(String command){
        return !command.trim().isEmpty();
    }


    protected static boolean isStartOptionValid(String command){
        if(!(command.equals("1") || command.equals("2")))
            return false;
        return true;
    }


}
