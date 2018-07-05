package com.codecool;

import java.util.Random;

public class Weather {
    static  boolean rain;

    public Weather(){
        rain = false;
    }

    static void setRaining(){  // 30% chance of rain.
        Random chance = new Random();
        rain = chance.nextInt(100) < 30;
          }

    static boolean isRaining(){
        return rain;
    }
}
