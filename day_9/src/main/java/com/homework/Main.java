package com.homework;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Stage road1 = new RoadStage(60);
        Stage tunnel = new TunnelStage(80, 2);
        Stage road2 = new RoadStage(40);
        
        Race race = new Race(4, Arrays.asList(road1, tunnel, road2));
        
        race.start();
    }
}