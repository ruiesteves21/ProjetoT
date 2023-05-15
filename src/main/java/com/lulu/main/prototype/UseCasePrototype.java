package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslParser;

import java.io.IOException;
import java.io.InputStream;

public class UseCasePrototype {
    public static void main(String[] args) throws InterruptedException, IOException {
        String dslYamlPath = "DslPrototype.yml";
        String toolYamlPath = "ToolPrototype.yml";
        ClassLoader classLoader = RunnerPrototype.class.getClassLoader();
        InputStream dslYamlStream = classLoader.getResourceAsStream(dslYamlPath);
        InputStream toolYamlStream = classLoader.getResourceAsStream(toolYamlPath);

        DslParser parser = new DslParser(dslYamlStream, toolYamlStream);
        parser.run();
    }
}
