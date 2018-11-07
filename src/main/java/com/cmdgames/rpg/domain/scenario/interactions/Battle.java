package com.cmdgames.rpg.domain.scenario.interactions;

import com.cmdgames.rpg.domain.characters.Enemy;

public final class Battle {

    private Enemy enemy;

    public Battle(final Enemy enemy){
        this.enemy = enemy;
    }

    public Enemy getEnemy() {
        return this.enemy;
    }

    public String getEventMessage() {
        return  "Choose one of the actions.\n" +
                "1. HIT\n" +
                "2. RUN\n" ;
    }

    public BattleContext doPlayerAction(final BattleContext battleContext) {
        switch (battleContext.getAction()){
            case HIT:
                this.enemy = BattleActions.doAttack(battleContext.getPlayer(), this.enemy);
                if(this.enemy.getHealth() == 0) {
                    BattleActions.getExperience(battleContext.getPlayer(), this.enemy);
                    battleContext.setFinished(true);
                    battleContext.setMessage("The enemy was defeated, now you can move forward" );
                }else {
                    battleContext.setMessage("The enemy was hit, his health is now " + this.enemy.getHealth());
                }
                break;
            case RUN:
                boolean canRun = BattleActions.canRun(battleContext.getPlayer());
                if(canRun) {
                    battleContext.setRun(canRun);
                }
                else
                    battleContext.setMessage("You cannot run away from the battle");
                break;
        }
        return battleContext;
    }

    public BattleContext doEnemyAction(BattleContext battleContext) {
        if(this.enemy.getHealth() == 0){
            battleContext.setMessage("");
            return battleContext;
        }

        battleContext.setPlayer(
                BattleActions.getHit(battleContext.getPlayer(), this.enemy));
        if(battleContext.getPlayer().getHealth() <= 0) {
            battleContext.setMessage("You got a critical hit, your vision is fading away");
            battleContext.setDead(true);
        }else {
            battleContext.setMessage("You got hit, your health is now " + battleContext.getPlayer().getHealth());
        }
        return battleContext;
    }
}
