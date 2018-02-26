package src.ru.sberbank.reflection.practice.entity;

public class Car {
    protected int odometer;
    protected String VIN;
    protected TransmissionType transmissionType;
    protected int horsePower;

    public int getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    public TransmissionType getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(TransmissionType transmissionType) {
        this.transmissionType = transmissionType;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }
}
