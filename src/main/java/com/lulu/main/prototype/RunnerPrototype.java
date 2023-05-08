package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;

public class RunnerPrototype {
    public static void main(String[] args) throws IOException {
        String pathToYaml = new String("C:\\Users\\ruesteves\\Documents\\ProjetoTese\\src\\main\\java\\com\\lulu\\main\\prototype\\DslPrototype.yml");
        String pathToAuxYaml = new String("C:\\Users\\ruesteves\\Documents\\ProjetoTese\\src\\main\\java\\com\\lulu\\main\\prototype\\ToolPrototype.yml");
        new DslRunner(pathToYaml, pathToAuxYaml);
    }
}

