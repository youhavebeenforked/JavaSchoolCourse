package ru.sberbank.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class SerializationTest {
    private Kryo kryo;
    private Input input;
    private Output output;
    private String fileName = "file.dat";

    @Before
    public void init() throws FileNotFoundException {
        kryo = new Kryo();
        output = new Output(new FileOutputStream(fileName));
        input = new Input(new FileInputStream(fileName));
    }

    @Test
    public void stringSerializationExample() {
        String strObj = "Простая строка";

        kryo.writeClassAndObject(output, strObj);
        output.close();

        Object theObject = kryo.readClassAndObject(input);
        input.close();

        assertEquals(theObject, "Простая строка");
    }

    @Test
    public void dateTimeSerializationExample() {
        LocalDateTime dateTime = LocalDateTime.now();

        kryo.writeClassAndObject(output, dateTime);
        output.close();

        Object theObject = kryo.readClassAndObject(input);
        input.close();

        assertEquals(theObject, dateTime);
    }

    @Test
    public void customObjectSerialization() {
        ComplexEntity complexEntity = new ComplexEntity();

        SimpleEntity entity = new SimpleEntity();
        entity.setName("First");
        entity.setTimeOfBirth(LocalDateTime.now());

        SimpleEntity entity2 = new SimpleEntity();
        entity2.setName("Second");
        entity2.setTimeOfBirth(LocalDateTime.now());

        complexEntity.addEntity(entity);
        complexEntity.addEntity(entity2);
        complexEntity.addEntity(entity);
        complexEntity.addEntity(entity2);

        kryo.writeClassAndObject(output, entity);
        //kryo.writeObject(output, entity2);
        kryo.writeClassAndObject(output, complexEntity);
        output.close();

        Object theObject = kryo.readClassAndObject(input);
        // Object theObject2 = kryo.readObject(input, SimpleEntity.class);
        Object theComplexObject = kryo.readClassAndObject(input);
        input.close();

        assertEquals(theObject, entity);
        //  assertEquals(theObject2, entity2);
        assertEquals(theComplexObject, complexEntity);
    }

    @Test
    public void customObjectSerializationWithSerializer() {
        ComplexEntity complexEntity = new ComplexEntity();
        complexEntity.setName(UUID.randomUUID().toString());

        SimpleEntity entity = new SimpleEntity();
        entity.setName("First");
        entity.setTimeOfBirth(LocalDateTime.now());

        SimpleEntity entity2 = new SimpleEntity();
        entity2.setName("Second");
        entity2.setTimeOfBirth(LocalDateTime.now());

        complexEntity.addEntity(entity);
        complexEntity.addEntity(entity2);
        complexEntity.addEntity(entity);
        complexEntity.addEntity(entity2);

        kryo.register(ComplexEntity.class, new ComplexEntitySerializer());
        kryo.writeClassAndObject(output, complexEntity);
        output.close();


        Object theComplexObject = kryo.readClassAndObject(input);
        input.close();

        assertEquals(theComplexObject, complexEntity);
    }
}
