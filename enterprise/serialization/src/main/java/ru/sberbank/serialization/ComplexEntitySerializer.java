package ru.sberbank.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

import java.util.ArrayList;

public class ComplexEntitySerializer extends Serializer<ComplexEntity> {
    @Override
    public void write(Kryo kryo, Output output, ComplexEntity object) {
        output.write(object.getName().getBytes());
        output.write(object.getList().size());
        object.getList().forEach(simpleEntity -> {
            kryo.writeObject(output, simpleEntity);
        });
    }

    @Override
    public ComplexEntity read(Kryo kryo, Input input, Class<ComplexEntity> type) {
        ComplexEntity ce = new ComplexEntity();
        ce.setName(new String(input.readBytes(36)));
        int length = input.read();
        ce.setList(new ArrayList<>(length));
        while (length-- > 0) {
            ce.addEntity(kryo.readObject(input, SimpleEntity.class));
        }
        return ce;
    }
}
