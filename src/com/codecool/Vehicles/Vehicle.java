package com.codecool.Vehicles;

import com.codecool.Race;

    public class Vehicle {
        String name;
        float speed;
        float distanceTraveled ;

        public void moveForAnHour(Race race) {
            if (race.isThereABrokenTruck()) {
                distanceTraveled += Math.min(75, speed);
            } else {
                distanceTraveled += speed;
            }
        }

        public float getDistanceTraveled(){
            return distanceTraveled;
        }

        // debug print
        public void print() {
            String type = this.getClass().getSimpleName();
            System.out.print("Name: " + name);
            System.out.print(" Distance: ");
            System.out.print(distanceTraveled );
            System.out.print(" Type: ");
            System.out.println(type);
        }
}
