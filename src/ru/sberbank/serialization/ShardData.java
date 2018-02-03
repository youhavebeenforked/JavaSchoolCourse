package ru.sberbank.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShardData implements Externalizable {
    private transient DateTimeFormatter sdf;

    private LocalDateTime creationDateTime = null;

    public ShardData() {
        sdf = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm:ss");
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(creationDateTime);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        creationDateTime = (LocalDateTime) in.readObject();
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    @Override
    public String toString() {
        return "ShardData{" +
                "creationDateTime=" + creationDateTime.format(sdf) +
                '}';
    }
}
