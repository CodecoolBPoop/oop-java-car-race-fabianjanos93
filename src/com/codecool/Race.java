package com.codecool;

import com.codecool.Vehicles.Car;
import com.codecool.Vehicles.Motorcycle;
import com.codecool.Vehicles.Truck;
import com.codecool.Vehicles.Vehicle;

public class Race {
    private int numberOfBrokenTruckOnRoad = 0;
    private Vehicle[] raceVehicles;
    private Weather weather = new Weather();
    private int turnsWhenRaining = 0;
    private int turnsWenTruckDown = 0;

    public static void main(String[] args) {
        Race race = new Race();
        race.createVehicles();
        race.simulateRace();
        race.sortVehicles();
        race.printRaceResults();
    }

    public boolean isItRaining(){
        return this.weather.isRaining();
    }
    public boolean isThereABrokenTruck() {
        return numberOfBrokenTruckOnRoad != 0;
    }

    public void truckBroke() {
        numberOfBrokenTruckOnRoad += 1;
    }

    public void truckFixed(){
        numberOfBrokenTruckOnRoad -= 1;
    }

    private void createVehicles() {
        raceVehicles = new Vehicle[30];
        for (int i = 0; i < 10; i++) {
            raceVehicles[i] = new Car();
        }
        for (int i = 10; i < 20; i++) {
            raceVehicles[i] = new Motorcycle();
        }
        for (int i = 20; i < 30; i++) {
            raceVehicles[i] = new Truck();
        }
    }

    private void simulateRace() {
        for (int round = 1; round <= 50; round++) {
            weather.setRaining();
            if(weather.isRaining()) {
                turnsWhenRaining++;
            }
            if(isThereABrokenTruck()) {
                turnsWenTruckDown++;
            }
            for (Vehicle racer : raceVehicles) {
                racer.moveForAnHour(this);
            }
        }
    }

    private void printRaceResults(){
        for(Vehicle racer: raceVehicles)
            racer.print();
        System.out.println("Turns when raining: " + turnsWhenRaining);
        System.out.println("Turns when Truck was down " + turnsWenTruckDown);
    }

    private void sortVehicles() {
        for(int i=0;i<raceVehicles.length;i++){
            for(int j=i; j>0; j--){
                if(raceVehicles[j].getDistanceTraveled()> raceVehicles[j-1].getDistanceTraveled()){
                    Vehicle temp = raceVehicles[j];
                    raceVehicles[j]=raceVehicles[j-1];
                    raceVehicles[j-1]=temp;
                }
            }
        }
    }

}
