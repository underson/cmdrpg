package com.cmdgames.rpg;

import com.cmdgames.rpg.domain.characters.Player;
import com.cmdgames.rpg.domain.scenario.exception.ArgumentNotAllowedException;
import com.cmdgames.rpg.domain.scenario.exception.DataNotFoundException;
import com.cmdgames.rpg.domain.scenario.location.maps.MadnessMountains;
import com.cmdgames.rpg.domain.scenario.exception.NavigationNotAllowedException;
import com.cmdgames.rpg.domain.scenario.interactions.Battle;
import com.cmdgames.rpg.domain.scenario.interactions.BattleContext;
import com.cmdgames.rpg.domain.scenario.location.Place;
import com.cmdgames.rpg.repository.PlayerRepository;
import com.cmdgames.rpg.utils.CommandLineUtils;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public final class Engine {

    private MadnessMountains map;
    private Player mainPlayer;

    public void startGame(){
        CommandLineUtils.print("At the mountains of madness");//ascii art
        CommandLineUtils.print("Welcome to the Artic");

        CommandLineUtils.print("Do you want to start a new game or continue an existing?");

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Player mainPlayer = startUpMainCharacter(command);

        CommandLineUtils.print("Hi Joseph, you just got to the bottom of the mountains, let´s check the base");

        this.mainPlayer = mainPlayer;
        this.map = new MadnessMountains(mainPlayer);
        // TODO fix this recursive function to avoid exceptions
        try {
            String command1 = newPlayerStep(map);
            navigate(map, command1);
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

    private Player startUpMainCharacter(String name){

        PlayerRepository playerRepository = new PlayerRepository();
        Player mainPlayer = new Player();

        try {
            mainPlayer = (Player) playerRepository.retrieve().getPersistableObject();
        } catch (FileNotFoundException | DataNotFoundException e) {
            mainPlayer.setName(name);
            mainPlayer.setAge(25);
            mainPlayer.setHealth(100);
            mainPlayer.setSpeed(60);
            mainPlayer.setStrength(60);
        }

        return mainPlayer;
    }

}