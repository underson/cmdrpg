package com.cmdgames.rpg.domain.scenario.interactions;

import com.cmdgames.rpg.domain.characters.Enemy;
import com.cmdgames.rpg.domain.Player;

public final class BattleActions {

    public static Enemy doAttack(Player player, Enemy enemy){
        enemy.setHealth(
                enemy.getHealth() - (player.getStrength() / 3)
        );
        return enemy;
    }

    public static Player getExperience(Player player, Enemy enemy){
        player.setStrength(
                player.getStrength() + (enemy.getStrength() / 2 )
        );
        player.setSpeed(
                player.getSpeed() + (enemy.getSpeed() / 2)
        );
        return player;
    }

    public static Player getHit(Player player, Enemy enemy){
        player.setHealth(
                player.getHealth() - (enemy.getStrength() / 10)
        );
        return player;
    }

    public static boolean canRun(Player player){
        if (player.getSpeed() < 10000)
            return false;
        return true;
    }

}
