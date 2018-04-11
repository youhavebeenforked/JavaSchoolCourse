package ru.sberbank.jschool.patterns.examples.structural;

public class Ex05Decorator {
    public static void main(String[] args) {
        Person person = new Batman(new Billionaire(new Orphan("Bruce Wayne")));
        System.out.println(person.introduction());
    }
}

interface Person {
    String introduction();
}

class Orphan implements Person {
    private String name;

    public Orphan(String name) {
        this.name = name;
    }

    @Override
    public String introduction() {
        return "My name is " + name + ", I'm an orphan.";
    }
}

class Billionaire implements Person {
    private final Person decorated;

    public Billionaire(Person person) {
        this.decorated = person;
    }

    @Override
    public String introduction() {
        return decorated.introduction()
                + " Also, I'm a billionaire.";
    }
}

class Batman implements Person {
    private final Person decorated;

    public Batman(Person person) {
        this.decorated = person;
    }

    @Override
    public String introduction() {
        return decorated.introduction()
                + " I'm the hero that Gotham deserves, but not the one it needs right now...";
    }
}
