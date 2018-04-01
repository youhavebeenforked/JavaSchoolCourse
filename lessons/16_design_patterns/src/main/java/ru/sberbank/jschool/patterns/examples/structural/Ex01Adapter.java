package ru.sberbank.jschool.patterns.examples.structural;

public class Ex01Adapter {
    public static void main(String[] args) {
        AssaultRifle rifle = new MonkeyCrewToAssaultRifleAdapter();
    }
}

interface AssaultRifle {
    void shoot() throws OutOfAmmoException;
    void reload();
    void switchFiringMode(Mode mode);
    Mode mode();
    int serialNumber();

    enum Mode {
        SINGLE, BURST, AUTO
    }

    class OutOfAmmoException extends Exception {
        public OutOfAmmoException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}

class AggressiveMonkeyCrew {

    private int coconuts;

    public AggressiveMonkeyCrew(int startingCoconuts) {
        coconuts = startingCoconuts;
    }

    public void tossCoconut() {
        if (coconuts <= 0) {
            throw new IllegalStateException("no coconuts to throw");
        }
        coconuts--;
    }

    public void gatherCoconut() {
        coconuts++;
    }

    public void abandonCoconuts() {
        coconuts = 0;
    }
}

class MonkeyCrewToAssaultRifleAdapter implements AssaultRifle {

    private static final int SINGLE_FIRE = 1;
    private static final int BURST_FIRE = 3;
    private static final int AUTO_FIRE = 10;

    private final AggressiveMonkeyCrew monkeyCrew = new AggressiveMonkeyCrew(30);
    private Mode mode = Mode.SINGLE;

    @Override
    public void shoot() throws OutOfAmmoException {
        try {
            fireCoconuts(mode);
        } catch (IllegalStateException e) {
            throw new OutOfAmmoException("out of ammo!", e);
        }
    }

    private void fireCoconuts(Mode mode) {
        int times = SINGLE_FIRE;
        if (mode == Mode.BURST) {
            times = BURST_FIRE;
        } else if (mode == Mode.AUTO) {
            times = AUTO_FIRE;
        }
        for (int i = 0; i < times; i++) {
            monkeyCrew.tossCoconut();
        }
    }

    @Override
    public void reload() {
        monkeyCrew.abandonCoconuts();
        for (int i = 0; i < 30; i++) {
            monkeyCrew.gatherCoconut();
        }
    }

    @Override
    public void switchFiringMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    public Mode mode() {
        return mode;
    }

    @Override
    public int serialNumber() {
        return this.hashCode();
    }
}
