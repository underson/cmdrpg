package com.cmdgames.rpg.repository;

import com.cmdgames.rpg.domain.scenario.exception.DataNotFoundException;

import java.io.*;

public class PlayerRepository {

    static final String PLAYER_FILE_PATH = "./data/player.dat";

    public void persist(Persistable persistable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(createSaveDataFile()))) {
            oos.writeObject(persistable.getPersistableObject());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Persistable retrieve() throws FileNotFoundException, DataNotFoundException {
        File saveDataFile = readSaveDataFile();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveDataFile))){
            return (Persistable) ois.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            throw new DataNotFoundException();
        }
    }

    private File readSaveDataFile() throws FileNotFoundException {
        File file = new File(PLAYER_FILE_PATH);
        if (file.exists()) {
            return file;
        }
        throw new FileNotFoundException("No saved data found!");
    }

    private File createSaveDataFile() {
        File file = new File(PLAYER_FILE_PATH);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return file;
    }

}
