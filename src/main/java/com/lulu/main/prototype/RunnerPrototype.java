package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;

public class RunnerPrototype {
    public static void main(String[] args) throws IOException {
        String pathToYaml = new String("C:\\Users\\ruesteves\\Documents\\GitHub\\LuluPerfTest\\src\\main\\java\\com\\lulu\\main\\prototype\\DslPrototype.yml");
        new DslRunner(pathToYaml);
    }
}
