package com.codecool.Vehicles;

import com.codecool.Race;

import java.util.Random;

public class Motorcycle extends Vehicle {
    static int nameNumber = 1;

    public Motorcycle(){
        name = "Motorcycle " + nameNumber++;
        speed = 100;
    }

    @Override
    public void moveForAnHour(Race race) {
        if (race.isItRaining()){
            Random slowAmount = new Random();
            distanceTraveled += speed - (slowAmount.nextInt(46)+5);
        } else {
            super.moveForAnHour(race);
        }
    }
}

