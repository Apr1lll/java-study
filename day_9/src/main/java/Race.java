package ru.sbt.study.java.core.threads.cars;

import java.util.ArrayList;
import java.util.Arrays;

class Race {

    private ArrayList<Stage> stages;

    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }
}