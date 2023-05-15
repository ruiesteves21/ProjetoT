package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;
import java.io.InputStream;

public class RunnerPrototype {
    public static void main(String[] args) throws IOException {
        String dslYamlPath = "DslPrototype.yml";
        String toolYamlPath = "ToolPrototype.yml";
        ClassLoader classLoader = RunnerPrototype.class.getClassLoader();
        InputStream dslYamlStream = classLoader.getResourceAsStream(dslYamlPath);
        InputStream toolYamlStream = classLoader.getResourceAsStream(toolYamlPath);

        new DslRunner(dslYamlStream, toolYamlStream);
    }
}

