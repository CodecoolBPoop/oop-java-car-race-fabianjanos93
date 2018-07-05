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
            float slowedSpeed = speed - (slowAmount.nextInt(46)+5);
            if (race.isThereABrokenTruck())
                distanceTraveled += Math.min(slowedSpeed,75);
            else
                distanceTraveled += slowedSpeed;
        } else {
            super.moveForAnHour(race);
        }
    }
}

