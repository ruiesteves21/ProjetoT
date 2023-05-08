package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslParser;

import java.io.IOException;

public class UseCasePrototype {
    public static void main(String[] args) throws InterruptedException, IOException {
        String dslYamlPath = "DslPrototype.yml";
        String toolYamlPath = "ToolPrototype.yml";
        ClassLoader classLoader = RunnerPrototype.class.getClassLoader();
        String pathToYaml = classLoader.getResource(dslYamlPath).getPath();
        String pathToAuxYaml = classLoader.getResource(toolYamlPath).getPath();

        DslParser parser = new DslParser(pathToYaml, pathToAuxYaml);
        parser.run();
    }
}
