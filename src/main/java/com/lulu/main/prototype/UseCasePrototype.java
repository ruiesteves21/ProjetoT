package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslParser;
import com.lulu.main.java.models.use_cases.UseCase;
import com.lulu.main.java.models.use_cases.UseCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class UseCasePrototype {
    public static void main(String[] args) throws InterruptedException, IOException {
        URL pathToYaml = new URL("file:///C:/Users/ruesteves/Documents/GitHub/LuluPerfTest/src/main/java/com/lulu/main/prototype/DslPrototype.yml");
        DslParser parser = new DslParser(pathToYaml);
        parser.run();
    }
}
