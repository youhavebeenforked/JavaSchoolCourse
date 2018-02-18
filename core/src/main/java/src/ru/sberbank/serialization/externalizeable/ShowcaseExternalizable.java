package src.ru.sberbank.serialization.externalizeable;

import java.io.*;
import java.time.LocalDateTime;

public class ShowcaseExternalizable {
    public static void main(String[] args) {
        String filename = "shard.bin";

        ShardData shard = new ShardData();
        shard.setCreationDateTime(LocalDateTime.now());

        System.out.println("Before save: " + shard);
        serialize(filename, shard);

        ShardData loadedData = deserialize(filename);
        System.out.println("After load: " + loadedData);
    }

    private static void serialize(String filename, ShardData worldData) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(worldData);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static ShardData deserialize(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return (ShardData) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
