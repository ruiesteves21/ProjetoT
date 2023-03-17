package com.lulu.main.java.models.use_cases;

import java.io.IOException;
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
            this.isRunning = true;
            useCase.run();
        }
    }

    public void runLoadTests() throws IOException, InterruptedException {
        for (UseCase useCase : useCases) {
            // Run the load test for each use case
            int totalThreads = useCase.numOfThreads;
            int threadsPerSecond = 1;
            int rampUpTime = 1;
            int duration = 60;
            String scriptPath = useCase.pathToScript.toString();
            String cmd = String.format("%s -t %d -r %d -d %d -s %d", useCase.cmdToRunScript, totalThreads, threadsPerSecond, rampUpTime, duration, scriptPath);
            System.out.println("Running load test for " + useCase.name);
            Process process = Runtime.getRuntime().exec(cmd);

            // Wait for the load test to finish
            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("Load test failed with exit code " + exitCode);
            }
        }
    }

    public boolean doneRunning() {
        return !isRunning();
    }

    public boolean isRunning() {
        for (UseCase uc : useCases) if (!uc.isRunning()) return false;
        return true;
    }

    public ArrayList<UseCase> getUseCases() {
        return useCases;
    }
}