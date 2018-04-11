package ru.sberbank.jschool.patterns.examples.structural;

import ru.sberbank.jschool.patterns.examples.structural.domain.ElectricOutlet;
import ru.sberbank.jschool.patterns.examples.structural.domain.Flamethrower;
import ru.sberbank.jschool.patterns.examples.structural.domain.Leafblower;
import ru.sberbank.jschool.patterns.examples.structural.domain.PortableElectricStove;

public class Ex02Facade {
    public static void main(String[] args) {
//        ClimateControl climateControl = new ClimateControlFacade();
    }
}

interface ClimateControl {
    void heaterOn();
    void heaterOff();
    void airConditionerOn();
    void seatHeaterOn();
}

class ClimateControlFacade implements ClimateControl {

    private final Flamethrower flamethrower;
    private final Leafblower leafblower;
    private final ElectricOutlet outlet;
    private final PortableElectricStove stove;

    public ClimateControlFacade(
            Flamethrower flamethrower,
            Leafblower leafblower,
            PortableElectricStove stove,
            ElectricOutlet outlet
    ) {
        this.flamethrower = flamethrower;
        this.leafblower = leafblower;
        this.stove = stove;
        this.outlet = outlet;
    }

    @Override
    public void heaterOn() {
        flamethrower.fire();
    }

    @Override
    public void heaterOff() {
        flamethrower.stop();
    }

    @Override
    public void airConditionerOn() {
        flamethrower.stop();
        leafblower.powerOn();
    }

    @Override
    public void seatHeaterOn() {
        stove.plugInto(outlet);
        stove.turnOn();
    }
}