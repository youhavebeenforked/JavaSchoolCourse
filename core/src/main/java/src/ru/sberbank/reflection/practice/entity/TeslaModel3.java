package src.ru.sberbank.reflection.practice.entity;

public class TeslaModel3 extends ElectricCar {
    private String number;
    private int firmwareVersion;

    public TeslaModel3(String number, int firmwareVersion) {
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

    @Override
    public void charge(double d) {
        if (d + charge <= batteryCapacity) {
            charge += d;
        } else {
            charge = batteryCapacity;
        }
    }
}
