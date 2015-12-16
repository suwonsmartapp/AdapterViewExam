package com.example.massivcode.adapterviewexam;

/**
 * Created by massivCode on 2015-12-16.
 */
public class Unit {

    private String race;
    private String name;

    public Unit(String race, String name) {
        this.race = race;
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
