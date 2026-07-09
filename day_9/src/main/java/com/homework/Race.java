package com.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Race {
    private final List<Stage> stages;
    private Car winner;
    private final int carCount;
    
    public Race(int carCount, List<Stage> stages) {
        this.carCount = carCount;
        this.stages = stages;
    }
    
    public List<Stage> getStages() {
        return stages;
    }
    
    public Car getWinner() {
        return winner;
    }
    
    public void setWinner(Car winner) {
        this.winner = winner;
    }
    
    public void start() {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        
        CountDownLatch startLatch = new CountDownLatch(1);
        CyclicBarrier finishBarrier = new CyclicBarrier(carCount, () -> {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        });
        
        List<Thread> threads = new ArrayList<>();
        
        for (int i = 0; i < carCount; i++) {
            Car car = new Car(this, startLatch, finishBarrier);
            Thread thread = new Thread(car);
            threads.add(thread);
            thread.start();
        }
        
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        startLatch.countDown();
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (winner != null) {
            System.out.println("Победитель гонки: " + winner.getName());
        }
    }
}