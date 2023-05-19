package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;

public class RunnerPrototype {
    public static void main(String[] args) throws IOException {
        /*String dslYamlPath = "DslPrototype.yml";
        String toolYamlPath = "ToolPrototype.yml";
        ClassLoader classLoader = RunnerPrototype.class.getClassLoader();
        String pathToYaml = classLoader.getResource(dslYamlPath).getPath();
        String pathToAuxYaml = classLoader.getResource(toolYamlPath).getPath();
         */


        String dslYamlURL = "https://raw.githubusercontent.com/ruiesteves21/ProjetoT/main/DslPrototype.yml";
        String toolYamlURL = "https://raw.githubusercontent.com/ruiesteves21/ProjetoT/main/ToolPrototype.yml";

        // Use the URLs in your code
        String pathToYaml = dslYamlURL;
        String pathToAuxYaml = toolYamlURL;


        new DslRunner(pathToYaml, pathToAuxYaml);
    }
}

