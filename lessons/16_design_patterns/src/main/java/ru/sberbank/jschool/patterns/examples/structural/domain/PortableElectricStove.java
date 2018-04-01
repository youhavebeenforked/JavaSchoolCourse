package ru.sberbank.jschool.patterns.examples.structural.domain;

public interface PortableElectricStove {
    void plugInto(ElectricOutlet outlet);
    void turnOn();
}
