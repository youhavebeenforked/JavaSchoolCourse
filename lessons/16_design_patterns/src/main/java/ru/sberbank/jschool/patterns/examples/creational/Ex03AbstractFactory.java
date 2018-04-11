package ru.sberbank.jschool.patterns.examples.creational;

import ru.sberbank.jschool.patterns.examples.creational.domain.hardware.Cpu;
import ru.sberbank.jschool.patterns.examples.creational.domain.hardware.Gpu;
import ru.sberbank.jschool.patterns.examples.creational.domain.hardware.PersistantStorage;
import ru.sberbank.jschool.patterns.examples.creational.domain.hardware.Ram;

import static ru.sberbank.jschool.patterns.examples.creational.domain.hardware.Cpu.*;
import static ru.sberbank.jschool.patterns.examples.creational.domain.hardware.Gpu.*;
import static ru.sberbank.jschool.patterns.examples.creational.domain.hardware.PersistantStorage.*;

public class Ex03AbstractFactory {

    public static void main(String[] args) {
        Computer officePc = createComputer(new OfficeComputerFactory());
        // hmm... but how to get those factories? a factoryFactory, of course!
    }

    public static Computer createComputer(ComputerFactory computerFactory) {
        Cpu cpu = computerFactory.createCpu();
        Gpu gpu = computerFactory.createGpu();
        PersistantStorage storage = computerFactory.createStorage();
        Ram ram = computerFactory.createRam();
        return new Computer(cpu, gpu, storage, ram);
    }

    static class Computer {
        Cpu cpu;
        Gpu gpu;
        PersistantStorage storage;
        Ram ram;

        public Computer(Cpu cpu, Gpu gpu, PersistantStorage storage, Ram ram) {
            this.cpu = cpu;
            this.gpu = gpu;
            this.storage = storage;
            this.ram = ram;
        }
    }
}


interface ComputerFactory {
    Cpu createCpu();
    Gpu createGpu();
    PersistantStorage createStorage();
    Ram createRam();
}

class OfficeComputerFactory implements ComputerFactory {
    @Override
    public Cpu createCpu() {
        return new EnergySavingCpu();
    }

    @Override
    public Gpu createGpu() {
        return new IntegratedGpu();
    }

    @Override
    public PersistantStorage createStorage() {
        return new Hdd();
    }

    @Override
    public Ram createRam() {
        return new Ram(4);
    }
}

class ServerFactory implements ComputerFactory {
    @Override
    public Cpu createCpu() {
        return new ServerCpu();
    }

    @Override
    public Gpu createGpu() {
        return new IntegratedGpu();
    }

    @Override
    public PersistantStorage createStorage() {
        return new Hdd();
    }

    @Override
    public Ram createRam() {
        return new Ram(64);
    }
}

class GamingRigFactory implements ComputerFactory {
    @Override
    public Cpu createCpu() {
        return new DesktopCpu();
    }

    @Override
    public Gpu createGpu() {
        return new DedicatedGpu();
    }

    @Override
    public PersistantStorage createStorage() {
        return new Ssd();
    }

    @Override
    public Ram createRam() {
        return new Ram(16);
    }
}


