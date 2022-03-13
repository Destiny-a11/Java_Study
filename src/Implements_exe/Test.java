package com.lhz.temp;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("唐僧", VehiclesFactory.getBoat());
        person.comm();
        person.passRiver();
        person.wire();
    }
}

interface Vehicles {
    public abstract void work();
}

class Horse implements Vehicles {

    @Override
    public void work() {
        System.out.println("普通道路上用马......");
    }
}

class Boat implements Vehicles {

    @Override
    public void work() {
        System.out.println("遇到河流用船.....");
    }
}

class Fly implements Vehicles {

    @Override
    public void work() {
        System.out.println("遇到火焰山使用飞机");
    }
}

class VehiclesFactory {

    private static Horse horse = new Horse();

    private VehiclesFactory() {
    }

    public static Horse getHorse() {
        return horse;
    }

    public static Boat getBoat() {
        return new Boat();
    }

    public static Fly getFlay() {
        return new Fly();
    }
}

class Person {
    private String name;
    private Vehicles vehicles;

    public Person(String name, Vehicles vehicles) {
        this.name = name;
        this.vehicles = vehicles;
    }

    public void comm() {
        if (!(vehicles instanceof Horse)) {
            vehicles = VehiclesFactory.getHorse();
        }
        vehicles.work();
    }

    public void passRiver() {
        if (!(vehicles instanceof Boat)) {
            vehicles = VehiclesFactory.getBoat();
        }
        vehicles.work();
    }

    public void wire() {
        if (!(vehicles instanceof Fly)) {
            vehicles = VehiclesFactory.getFlay();
        }
        vehicles.work();
    }
}


