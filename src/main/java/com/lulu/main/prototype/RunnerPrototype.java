package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;

public class RunnerPrototype {
    public static void main(String[] args) throws IOException {
        String dslYamlPath = "./DslPrototype.yml";
        String toolYamlPath = "./ToolPrototype.yml";
        /*
        ClassLoader classLoader = RunnerPrototype.class.getClassLoader();
        String pathToYaml = classLoader.getResource(dslYamlPath).getPath();
        String pathToAuxYaml = classLoader.getResource(toolYamlPath).getPath();
         */

        new DslRunner(dslYamlPath, dslYamlPath);
    }
}

