package src.ru.sberbank.reflection.practice.entity;

public abstract class ElectricCar extends Car {
    protected double batteryCapacity;
    protected double charge;

    public abstract void charge(double d);

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(double batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }
}
