package com.homework;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicBoolean;

public class Car implements Runnable {
    private static int carCount = 0;
    private final int carNumber;
    private final String name;
    private final Race race;
    private final CountDownLatch startLatch;
    private final CyclicBarrier finishBarrier;
    private volatile boolean isWinner = false;
    private static final AtomicBoolean winnerFound = new AtomicBoolean(false);
    
    public Car(Race race, CountDownLatch startLatch, CyclicBarrier finishBarrier) {
        this.race = race;
        this.startLatch = startLatch;
        this.finishBarrier = finishBarrier;
        this.carNumber = ++carCount;
        this.name = "Участник #" + carNumber;
    }
    
    public String getName() {
        return name;
    }
    
    @Override
    public void run() {
        try {
            System.out.println(name + " готовится");
            
            startLatch.await();
            
            for (int i = 0; i < race.getStages().size(); i++) {
                Stage stage = race.getStages().get(i);
                stage.go(this);
                
                if (i == race.getStages().size() - 1) {
                    if (winnerFound.compareAndSet(false, true)) {
                        System.out.println(name + " - WIN");
                        race.setWinner(this);
                    }
                }
            }
            
            finishBarrier.await();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}