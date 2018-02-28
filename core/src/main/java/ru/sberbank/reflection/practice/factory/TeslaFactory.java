package ru.sberbank.reflection.practice.factory;

import ru.sberbank.reflection.practice.entity.Car;
import ru.sberbank.reflection.practice.entity.TeslaModel3;

public class TeslaFactory implements CarFactory {
    @Override
    public Car create() {
        TeslaModel3 tesla = new TeslaModel3("4KOE56 178", 17);
        tesla.setHorsePower(258);
        tesla.setVIN("GAUBH54B11L111054");
        tesla.setBatteryCapacity(50_0000);
        return tesla;
    }
}
