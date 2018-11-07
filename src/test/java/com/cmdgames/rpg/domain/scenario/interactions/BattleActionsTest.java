package com.cmdgames.rpg.domain.scenario.interactions;

import com.cmdgames.rpg.domain.characters.ElderThing;
import com.cmdgames.rpg.domain.characters.Enemy;
import com.cmdgames.rpg.domain.Player;
import org.junit.Test;
import static org.junit.Assert.*;
public class BattleActionsTest {

    @Test
    public void doAttack(){
        Player player = new Player();
        player.setStrength(99);
        Enemy enemy = new ElderThing(99, 100, 100);
        enemy = BattleActions.doAttack(player, enemy);
        assertEquals(66, enemy.getHealth());
    }

    @Test
    public void getExperience(){

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
