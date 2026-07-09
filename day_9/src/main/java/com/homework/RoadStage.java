package com.homework;

public class RoadStage extends Stage {
    public RoadStage(int length) {
        this.length = length;
        this.description = "Дорога " + length + " метров";
    }
    
    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length * 10); // симуляция прохождения
            System.out.println(car.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}