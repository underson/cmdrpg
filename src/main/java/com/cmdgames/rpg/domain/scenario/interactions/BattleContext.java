package com.cmdgames.rpg.domain.scenario.interactions;

import com.cmdgames.rpg.domain.Player;

public final class BattleContext {

    private Player player;
    private String message;
    private int commandAction;
    private boolean run;
    private boolean finished;
    private boolean dead;


    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean isRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isDead() {
        return dead;
    }

    public int getCommandAction() {
        return commandAction;
    }

    public void setCommandAction(int commandAction) {
        this.commandAction = commandAction;
    }
}
