package com.homework;

import java.util.concurrent.Semaphore;

public class TunnelStage extends Stage {
    private Semaphore semaphore;
    
    public TunnelStage(int length, int maxCarsInTunnel) {
        this.length = length;
        this.description = "Тоннель " + length + " метров";
        this.semaphore = new Semaphore(maxCarsInTunnel);
    }
    
    @Override
    public void go(Car car) {
        try {
            System.out.println(car.getName() + " готовится к этапу(ждет): " + description);
            semaphore.acquire();
            System.out.println(car.getName() + " начал этап: " + description);
            Thread.sleep(length * 10);
            System.out.println(car.getName() + " закончил этап: " + description);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}