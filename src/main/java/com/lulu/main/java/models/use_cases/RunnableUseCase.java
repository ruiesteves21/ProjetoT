package com.lulu.main.java.models.use_cases;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;

public class RunnableUseCase implements Runnable {
    String name;
    String executionScript;
    volatile boolean isRunning = true; // Has to be defaulted to true

    public RunnableUseCase(String name, URL pathToScript, String cmdToRunScript) {
        this.name = name;
        this.executionScript = cmdToRunScript + " " + pathToScript;
    }

    public void run() {
        // TODO: Use the Process class to get information about
        // the test scripts that are run. (failure, latency, etc)
        isRunning = true;
        System.out.println("Running \"" + executionScript + "\"");
        try {
            Process p = Runtime.getRuntime().exec(executionScript);
            int exitCode = p.waitFor();
            if (exitCode != 0) {
                // The subprocess failed
                // TODO: Handle the failure
            }
        } catch (IOException | InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        } finally {
            isRunning = false;
        }
    }
}
