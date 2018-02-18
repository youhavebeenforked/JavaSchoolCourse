package src.ru.sberbank.serialization.serializeable;

import java.io.Serializable;

public class WorldData extends CoreData implements Serializable {
    // private static final long serialVersionUID = 1L;

    private static String maxAge;

    private String worldName;
    private int worldAge;

    // private static final ObjectStreamField[] serialPersistentFields = { new ObjectStreamField("worldName", String.class) };


    private transient int daysFromLastSave;

    public static String getMaxAge() {
        return maxAge;
    }

    public static void setMaxAge(String maxAge) {
        WorldData.maxAge = maxAge;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public int getWorldAge() {
        return worldAge;
    }

    public void setWorldAge(int worldAge) {
        this.worldAge = worldAge;
    }

    public int getDaysFromLastSave() {
        return daysFromLastSave;
    }

    public void setDaysFromLastSave(int daysFromLastSave) {
        this.daysFromLastSave = daysFromLastSave;
    }

    @Override
    public String toString() {
        return "WorldData{" +
                "worldName='" + worldName + '\'' +
                ", worldAge=" + worldAge +
                ", daysFromLastSave=" + daysFromLastSave +
                ", CoreData.seed=" + this.getSeed() +
                '}';
    }
}
