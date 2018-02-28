package ru.sberbank.reflection.practice.entity;

import ru.sberbank.reflection.practice.annotation.ExperimentalFeature;
import ru.sberbank.reflection.practice.annotation.Prototype;

@Prototype(version = 9001)
public class TeslaModelHydro extends ElectricCar {
    private String number;
    private int firmwareVersion;

    @ExperimentalFeature
    private String codename = "Poseidon";

    public TeslaModelHydro(String number, int firmwareVersion) {
        this.number = number;
        this.firmwareVersion = firmwareVersion;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(int firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    @ExperimentalFeature
    public void fuelWithWater(int liters) {
        this.charge(liters / 2);
    }

    @Override
    public void charge(double d) {
        if (d + charge <= batteryCapacity) {
            charge += d;
        } else {
            charge = batteryCapacity;
        }
    }

    @Override
    public String toString() {
        return "TeslaModel3{" +
                "number='" + number + '\'' +
                ", firmwareVersion=" + firmwareVersion +
                ", batteryCapacity=" + batteryCapacity +
                ", charge=" + charge +
                ", odometer=" + odometer +
                ", VIN='" + VIN + '\'' +
                ", transmissionType=" + transmissionType +
                ", horsePower=" + horsePower +
                "} " + super.toString();
    }
}
