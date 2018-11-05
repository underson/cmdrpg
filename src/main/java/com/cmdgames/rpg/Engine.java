package com.cmdgames.rpg;

import com.cmdgames.rpg.model.characters.Player;
import com.cmdgames.rpg.model.scenario.exception.ArgumentNotAllowedException;
import com.cmdgames.rpg.model.scenario.MadnessMountains;
import com.cmdgames.rpg.model.scenario.exception.NavigationNotAllowedException;
import com.cmdgames.rpg.model.scenario.interactions.Battle;
import com.cmdgames.rpg.model.scenario.interactions.BattleContext;
import com.cmdgames.rpg.model.scenario.location.Place;
import com.cmdgames.rpg.utils.CommandLineUtils;

import java.util.List;
import java.util.Scanner;

public final class Engine {

    private MadnessMountains map;
    private Player mainPlayer;

    public void startGame(){
        CommandLineUtils.print("At the mountains of madness");//ascii art
        CommandLineUtils.print("Welcome to the Artic");
        Player mainPlayer = startUpMainCharacter();
        this.mainPlayer = mainPlayer;
        this.map = new MadnessMountains(mainPlayer);
        // TODO do this as recursive function
        try {
            String command = newPlayerStep(map);
            navigate(map, command);
        }catch (ArgumentNotAllowedException ex){
            CommandLineUtils.print(ex.getMessage());
        }
    }

    private void navigate (final MadnessMountains madnessMountains, String command){
        try {
            Place actualPlace = madnessMountains.navigate(Integer.valueOf(command));
            interactWith(actualPlace);
            command = newPlayerStep(madnessMountains);
        } catch (NavigationNotAllowedException | ArgumentNotAllowedException ex) {
            CommandLineUtils.print(ex.getMessage());
        }
        navigate(madnessMountains, command);
    }


    private void interactWith(final Place actualPlace) {
        //CommandLineUtils.print(actualPlace.getPlaceAscii());
        CommandLineUtils.print(actualPlace.getPlaceDescription());
        actualPlace.getPlaceEvents().forEach( event -> {
            reactToEvent(event);
        });
    }

    private void reactToEvent(final Battle event) {

        if(event.getEnemy().getHealth() <= 0){
            CommandLineUtils.print("There is a dead " + event.getEnemy().getName() + "here");
            return;
        }

        CommandLineUtils.print("You are in a fight against an " + event.getEnemy().getName());
        CommandLineUtils.print(event.getEnemy().getName() + " says " + event.getEnemy().getEnemyMessage());
        CommandLineUtils.print(event.getEventMessage());
        BattleContext battleContext = new BattleContext();

        try {
            String command = readAndCheck();
            battleContext.setPlayer(this.mainPlayer);
            battleContext.setAction(
                    battleContext.getBattleAction(Integer.valueOf(command))
            );
            battleContext = event.doPlayerAction(battleContext);
            CommandLineUtils.print(battleContext.getMessage());
            battleContext = event.doEnemyAction(battleContext);
            CommandLineUtils.print(battleContext.getMessage());
        } catch (ArgumentNotAllowedException ex) {
            CommandLineUtils.print(ex.getMessage());
            reactToEvent(event);
        }

        if(battleContext.isRun() || battleContext.isFinished())
            return;

        if(battleContext.isDead())
            startGame();

        reactToEvent(event);
    }

    private String newPlayerStep(final MadnessMountains madnessMountains) throws ArgumentNotAllowedException {
        CommandLineUtils.print(madnessMountains.getAllowedDirectionsMessage());
        return readAndCheck();
    }

    private String readAndCheck() throws ArgumentNotAllowedException {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<String> errors = CommandLineUtils.isCommandValid(command);
        errors.forEach(
                error -> CommandLineUtils.print(error));
        if(!errors.isEmpty())
            throw new ArgumentNotAllowedException();
        return command;
    }

    private Player startUpMainCharacter(){
        Player mainPlayer = new Player();
        mainPlayer.setName("User 1");
        mainPlayer.setAge(25);
        mainPlayer.setHealth(100);
        mainPlayer.setSpeed(60);
        mainPlayer.setStrength(60);
        return mainPlayer;
    }

}