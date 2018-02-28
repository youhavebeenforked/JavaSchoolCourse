package ru.sberbank.reflection.practice.factory;

import ru.sberbank.reflection.practice.entity.Car;
import ru.sberbank.reflection.practice.entity.FordMustang;

public class FordFactory implements CarFactory {

    @Override
    public Car create() {
        FordMustang fordMustang = new FordMustang("0XAP01 777");
        fordMustang.setHorsePower(426);
        fordMustang.setVIN("GAHSR48B12L714302");
        fordMustang.setFuelMaxCapacity(58);
        return fordMustang;
    }
}
