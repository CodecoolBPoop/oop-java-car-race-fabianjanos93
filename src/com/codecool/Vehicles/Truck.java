package com.codecool.Vehicles;

import com.codecool.Race;

import java.util.Random;

public class Truck extends Vehicle {
    int breakdownTurnsLeft = 0;

    public Truck(){
        Random nameNumber = new Random();
        name = "" + (nameNumber.nextInt(999)+1);
        speed = 100;
    }
    @Override
    public void moveForAnHour(Race race) {
        if (breakdownTurnsLeft == 0) {
            Random breakdownChance = new Random();
            if (breakdownChance.nextInt(100) < 5) {
                breakdownTurnsLeft = 2;
                race.truckBroke();
            } else {
                super.moveForAnHour(race);
            }
        } else {
            breakdownTurnsLeft -= 1;
            if (breakdownTurnsLeft == 0){
                race.truckFixed();
            }
        }
    }
}
