package com.cmdgames.rpg.repository;

import java.io.*;

public class SaveService {

    static final String FILE_PATH = "./data/rpg.dat";

    public void persist(Persistable persistable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(createSaveDataFile()))) {
            oos.writeObject(persistable.getPersistableObject());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

  /*  public void load() throws FileNotFoundException {
        File saveDataFile = readSaveDataFile();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(saveDataFile))){
            InternalCache.addCharacter((Character) ois.readObject());
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/

    private File readSaveDataFile() throws FileNotFoundException {
        File file = new File(FILE_PATH);
        if (file.exists()) {
            return file;
        }
        throw new FileNotFoundException("No saved data found!");
    }

    private File createSaveDataFile() {
        File file = new File(FILE_PATH);
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