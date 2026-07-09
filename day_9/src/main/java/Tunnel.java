package ru.sbt.study.java.core.threads.cars;

import java.util.concurrent.Semaphore;

class Tunnel extends Stage {

    private static final Semaphore SEMAPHORE = new Semaphore(2);

    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
            
            SEMAPHORE.acquire();
            
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            
            System.out.println(c.getName() + " закончил этап: " + description);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            SEMAPHORE.release();
        }
    }
}