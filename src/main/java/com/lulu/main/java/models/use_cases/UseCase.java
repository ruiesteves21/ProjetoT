package com.lulu.main.java.models.use_cases;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class UseCase {
    public String name;
    public URL pathToScript;
    public String cmdToRunScript;
    public int numOfThreads;
    public ArrayList<RunnableUseCase> runnableUseCases = new ArrayList<>();

    public UseCase(String name, String pathToScript, String cmdToRunScript, int numOfThreads) throws MalformedURLException {
        this.name = name;
        //String encodedUrl = URLEncoder.encode(pathToScript, StandardCharsets.UTF_8);
        //Path path = Paths.get(encodedUrl);
        URL url = new URL(pathToScript);
        this.pathToScript = url;
        this.cmdToRunScript = cmdToRunScript;
        this.numOfThreads = numOfThreads;
    }

    public void run() {
        setRunnableUseCases();
        System.out.println("Preparing " + name + " threads");
        for (RunnableUseCase ruc : runnableUseCases) {
            Thread t = new Thread(ruc, ruc.name);
            t.start();
        }
    }

    public boolean isRunning() {
        for (RunnableUseCase ruc : runnableUseCases) if(!ruc.isRunning) return false;
        return true;
    }


    private void setRunnableUseCases() {
        for (int i = 1; i <= numOfThreads; i++) {
            String threadName = name + i;
            RunnableUseCase ruc = new RunnableUseCase(threadName, pathToScript, cmdToRunScript) {
                @Override
                public void run() {
                    try {
                        // Run the script using the Runtime class
                        Process process = Runtime.getRuntime().exec(cmdToRunScript + " " + pathToScript.toString());
                        // Wait for the script to finish
                        process.waitFor();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    isRunning = false;
                }
            };
            runnableUseCases.add(ruc);
        }
    }

}
