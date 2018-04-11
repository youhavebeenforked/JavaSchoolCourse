package ru.sberbank.jschool.patterns.examples.creational.domain.hardware;

public class Ram {
    private int capacityInGb;

    public Ram(int capacityInGb) {
        this.capacityInGb = capacityInGb;
    }

    public int getCapacityInGb() {
        return capacityInGb;
    }
}
