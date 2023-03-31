package com.lulu.main.java.models.use_cases;

import java.io.IOException;

public class RunnableUseCase implements Runnable {
    String name;
    String executionScript;
    String cmdToRunScript;
    String pathToScript;
    volatile boolean isRunning = true; // Has to be defaulted to true

    public RunnableUseCase(String name, String pathToScript, String cmdToRunScript) {
        this.name = name;
        this.pathToScript = pathToScript;
        this.cmdToRunScript = cmdToRunScript;
        this.executionScript = cmdToRunScript + " " + pathToScript;
    }
    public void run() {
        isRunning = true;
        try {
            System.out.println("Running \"" + executionScript + "\"");
            Process process = Runtime.getRuntime().exec(executionScript);
            process.waitFor();
            System.out.println("\"" + executionScript + "\" completed");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            isRunning = false;
        }
    }

}
