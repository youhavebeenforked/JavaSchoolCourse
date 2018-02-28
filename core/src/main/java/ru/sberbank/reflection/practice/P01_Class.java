package ru.sberbank.reflection.practice;

import ru.sberbank.reflection.practice.entity.Car;
import ru.sberbank.reflection.practice.factory.FordFactory;
import ru.sberbank.reflection.practice.factory.TeslaFactory;

public class P01_Class {

    public static void main(String[] args) {
        FordFactory fordFactory = new FordFactory();
        TeslaFactory teslaFactory = new TeslaFactory();

        System.out.println(getCarInfo(teslaFactory.create()));
        System.out.println(getCarInfo(fordFactory.create()));
    }

    private static String getCarInfo(Car car) {
        StringBuilder sb = new StringBuilder("it is ");

        sb.append("Model name: ").append("").append(" "); // название модели

        sb.append("Car type: ").append("").append(" "); // тип машины

        sb.append(" ").append("").append(" "); // параметр характеризующий количество топлива.

        sb.append(" ").append("").append(" "); // как заправить/зарядить

        sb.append("VIN: ").append("").append(" "); // VIN

        return sb.toString();
    }
}
