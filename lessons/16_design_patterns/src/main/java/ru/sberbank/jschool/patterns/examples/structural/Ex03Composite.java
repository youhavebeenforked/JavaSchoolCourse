package ru.sberbank.jschool.patterns.examples.structural;

import java.util.ArrayList;
import java.util.List;

public class Ex03Composite {

    public static void main(String[] args) {
        //initialization hidden away
        Explosive explosive = new ClusterBomb();
        explosive.add(new HomemadeBomb());
        explosive.add(new HomemadeBomb());
        explosive.add(new HomemadeBomb());

        System.out.println(explosive.tntKgEquivalent());
        explosive.prime();
        explosive.detonate();
    }
}

interface Explosive {
    void prime();
    void detonate();
    void add(Explosive unit);
    Explosive remove(int index);
    int tntKgEquivalent();
}

class HomemadeBomb implements Explosive {
    private static final int TNT_EQUIVALENT = 1;

    private boolean isPrimed = false;

    @Override
    public void prime() {
        isPrimed = true;
        System.out.println("priming bomb");
    }

    @Override
    public void detonate() {
        if (isPrimed) {
            System.out.println("KABOOM!");
        }
    }

    @Override
    public int tntKgEquivalent() {
        return TNT_EQUIVALENT;
    }

    @Override
    public void add(Explosive unit) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Explosive remove(int index) {
        throw new UnsupportedOperationException();
    }
}

class ClusterBomb implements Explosive {
    private List<Explosive> clusters = new ArrayList<>();

    @Override
    public void prime() {
        for (Explosive cluster : clusters) {
            cluster.prime();
        }
    }

    @Override
    public void detonate() {
        for (Explosive cluster : clusters) {
            cluster.detonate();
        }
    }

    @Override
    public void add(Explosive unit) {
        clusters.add(unit);
    }

    @Override
    public Explosive remove(int index) {
        return clusters.remove(index);
    }

    @Override
    public int tntKgEquivalent() {
        return clusters.stream()
                .mapToInt(Explosive::tntKgEquivalent)
                .sum();
    }
}
