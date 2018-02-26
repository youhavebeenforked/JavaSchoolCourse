package src.ru.sberbank.reflection.practice.entity;

public abstract class FuelCar extends Car {
    protected double fuelMaxCapacity;
    protected double fuelVolume;

    public abstract void fillTank(double volume);

    public double getFuelMaxCapacity() {
        return fuelMaxCapacity;
    }

    public void setFuelMaxCapacity(double fuelMaxCapacity) {
        this.fuelMaxCapacity = fuelMaxCapacity;
    }

    public double getFuelVolume() {
        return fuelVolume;
    }

    public void setFuelVolume(double fuelVolume) {
        this.fuelVolume = fuelVolume;
    }
}
