package com.lulu.main.java.models.use_cases;

import java.util.ArrayList;

public class UseCases {
    public ArrayList<UseCase> useCases;
    public boolean isRunning = false;

    public UseCases(ArrayList<UseCase> useCases) {
        this.useCases = useCases;
    }

    public void start() {
        for (UseCase useCase : useCases) {
            System.out.println("Building " + useCase.name);
            useCase.run();
        }
        this.isRunning = true;
    }

    public boolean doneRunning() {
        return !isRunning();
    }

    public boolean isRunning() {
        for (UseCase uc : useCases) {
            if (uc.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<UseCase> getUseCases() {
        return useCases;
    }
}