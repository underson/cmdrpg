package com.cmdgames.rpg.model.scenario.interactions;

import com.cmdgames.rpg.model.characters.Player;

public final class BattleContext {

    private BattleAction action;
    private Player player;
    private String message;
    private boolean run;
    private boolean finished;
    private boolean dead;


    public BattleAction getBattleAction(int command) {
        switch (command){
            case 1:
                return BattleAction.HIT;
            case 2:
                return BattleAction.RUN;
            default:
                return BattleAction.RUN;
        }
    }

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

    public BattleAction getAction() {
        return action;
    }

    public void setAction(BattleAction action) {
        this.action = action;
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

    public enum BattleAction {
        HIT, RUN
    }

}
