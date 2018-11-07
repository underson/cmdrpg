package com.cmdgames.rpg.repository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MapRepository {

    static final String MAP_FILE_PATH = "./data/map.dat";

    public void persist(Persistable persistable) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(createSaveDataFile()))) {
            oos.writeObject(persistable.getPersistableObject());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private File createSaveDataFile() {
        File file = new File(MAP_FILE_PATH);
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
