package ru.sberbank.jschool.patterns.examples.creational;

import ru.sberbank.jschool.patterns.examples.creational.domain.food.Beverage;
import ru.sberbank.jschool.patterns.examples.creational.domain.food.Dish;

import java.util.ArrayList;
import java.util.List;

import static ru.sberbank.jschool.patterns.examples.creational.domain.food.Beverage.*;
import static ru.sberbank.jschool.patterns.examples.creational.domain.food.Dish.*;

public class Ex04Builder {
    public static void main(String[] args) {
        LunchDirector director = new SmallLunchDirector();
        Lunch lunch = director.build(new FastFoodLunchBuilder());
    }
}

interface LunchBuilder {
    void buildSoup();
    void buildEntree();
    void buildMainCourse();
    void buildDessert();
    void buildSnack();
    void buildBeverage();
    Lunch serveLunch();
}

class FastFoodLunchBuilder implements LunchBuilder {
    private final Lunch lunch = new Lunch();

    @Override
    public void buildSoup() {}

    @Override
    public void buildEntree() {
        lunch.addDish(new ChickenNuggets());
    }

    @Override
    public void buildMainCourse() {
        lunch.addDish(new Hamburger());
    }

    @Override
    public void buildDessert() {
        lunch.addDish(new IceCream());
    }

    @Override
    public void buildSnack() {
        lunch.addDish(new FrenchFries());
    }

    @Override
    public void buildBeverage() {
        lunch.setBeverage(new Coke());
    }

    @Override
    public Lunch serveLunch() {
        return lunch;
    }
}

class CafeteriaLunchBuilder implements LunchBuilder {

    private final Lunch lunch = new Lunch();

    @Override
    public void buildSoup() {
        lunch.addDish(new ChickenSoup());
    }

    @Override
    public void buildEntree() {
        lunch.addDish(new VegetableStew());
    }

    @Override
    public void buildMainCourse() {
        lunch.addDish(new Steak());
    }

    @Override
    public void buildDessert() {
        lunch.addDish(new Cake());
    }

    @Override
    public void buildSnack() {
        lunch.addDish(new MashedPotatoes());
    }

    @Override
    public void buildBeverage() {
        lunch.setBeverage(new Coffee());
    }

    @Override
    public Lunch serveLunch() {
        return lunch;
    }
}

class Lunch {
    private List<Dish> dishes = new ArrayList<>();
    private Beverage beverage;

    public void addDish(Dish dish) {
        if (dish != null) {
            dishes.add(dish);
        }
    }

    public void setBeverage(Beverage beverage) {
        if (beverage != null) {
            this.beverage = beverage;
        }
    }

    public Beverage getBeverage() {
        if (beverage == null) {
            beverage = new Water();
        }
        return beverage;
    }
}

interface LunchDirector {
    Lunch build(LunchBuilder builder);
}

class SmallLunchDirector implements LunchDirector {
    @Override
    public Lunch build(LunchBuilder builder) {
        builder.buildSnack();
        builder.buildMainCourse();
        builder.buildBeverage();
        return builder.serveLunch();
    }
}

class FullLunchDirector implements LunchDirector {
    @Override
    public Lunch build(LunchBuilder builder) {
        builder.buildSoup();
        builder.buildEntree();
        builder.buildMainCourse();
        builder.buildDessert();
        builder.buildSnack();
        builder.buildBeverage();
        return builder.serveLunch();
    }
}


