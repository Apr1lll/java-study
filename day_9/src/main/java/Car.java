package ru.sbt.study.java.core.threads.cars;

import java.util.concurrent.CountDownLatch;

class Car implements Runnable {

    private static int CARS_COUNT;
    private static boolean winnerFound = false;

    static {
        CARS_COUNT = 0;
    }

    private Race race;
    private int speed;
    private String name;
    private CountDownLatch startLatch;
    private CountDownLatch finishLatch;

    public Car(Race race, int speed, CountDownLatch startLatch, CountDownLatch finishLatch) {
        this.race = race;
        this.speed = speed;
        this.startLatch = startLatch;
        this.finishLatch = finishLatch;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            
            startLatch.await();
            
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
            
            synchronized (Car.class) {
                if (!winnerFound) {
                    winnerFound = true;
                    System.out.println(this.name + " - WIN");
                }
            }
            
            finishLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}