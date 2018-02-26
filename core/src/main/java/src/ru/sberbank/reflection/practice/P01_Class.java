package src.ru.sberbank.reflection.practice;

import src.ru.sberbank.reflection.practice.entity.Car;
import src.ru.sberbank.reflection.practice.entity.FordMustang;
import src.ru.sberbank.reflection.practice.entity.TeslaModel3;

public class P01_Class {

    public static void main(String[] args) {
        TeslaModel3 t = new TeslaModel3("4KOE56 178", 17);
        t.setHorsePower(258);
        t.setVIN("GAUBH54B11L111054");
        t.setBatteryCapacity(50_0000);

        FordMustang fordMustang = new FordMustang("0XAP01 777");
        fordMustang.setHorsePower(426);
        fordMustang.setVIN("GAHSR48B12L714302");
        fordMustang.setFuelMaxCapacity(58);
    }

    private static String getCarInfo(Car car) {
        StringBuilder sb = new StringBuilder("it is ");

        sb.append(" ").append("").append(" "); // название модели

        sb.append(" ").append("").append(" "); // тип машины

        sb.append(" ").append("").append(" "); // параметр характеризующий количество топлива.

        sb.append(" ").append("").append(" "); // как заправить/зарядить

        sb.append(" ").append("").append(" "); // VIN

        return sb.toString();
    }
}
