package ru.sberbank.reflection.practice.entity;

public class FordMustang extends FuelCar {
    private String number;

    public FordMustang(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public void fillTank(double volume) {
        if (volume + fuelVolume <= fuelMaxCapacity) {
            fuelVolume += volume;
        } else {
            fuelVolume = fuelMaxCapacity;
        }
    }

    @Override
    public String toString() {
        return "FordMustang{" +
                "number='" + number + '\'' +
                ", fuelMaxCapacity=" + fuelMaxCapacity +
                ", fuelVolume=" + fuelVolume +
                ", odometer=" + odometer +
                ", VIN='" + VIN + '\'' +
                ", transmissionType=" + transmissionType +
                ", horsePower=" + horsePower +
                "} " + super.toString();
    }
}
