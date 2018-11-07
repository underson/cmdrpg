package com.cmdgames.rpg.service;

import com.cmdgames.rpg.domain.Player;
import com.cmdgames.rpg.domain.scenario.exception.DataNotFoundException;
import com.cmdgames.rpg.repository.PlayerRepository;

import java.io.FileNotFoundException;

public class PlayerService {

    public Player retrieveSavedPlayer() {
        PlayerRepository playerRepository = new PlayerRepository();
        Player mainPlayer;
        try {
            mainPlayer = (Player) playerRepository.retrieve().getPersistableObject();
        } catch (FileNotFoundException | DataNotFoundException e) {
            return null;
        }
        return mainPlayer;
    }

    public void savePlayer(Player player) {
        PlayerRepository playerRepository = new PlayerRepository();
        playerRepository.persist(player);
    }

}