package src.ru.sberbank.serialization.serializeable;

import java.io.*;

public class ShowcaseSerializable {
    public static void main(String[] args) {
        String filename = "world.bin";

        WorldData world = new WorldData();
        world.setWorldName("Wayne's World");
        world.setWorldAge(100);
        world.setDaysFromLastSave(42);
        world.setSeed("custom");

        System.out.println("Before serialization: " + world);
        serialize(filename, world);

        WorldData loadedData = deserialize(filename);
        System.out.println("After deserialization: " + loadedData);
    }

    private static void serialize(String filename, WorldData worldData) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(worldData);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static WorldData deserialize(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fis)) {
            return (WorldData) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
