package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslParser;
import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;

public class UseCasePrototype {
    public static void main(String[] args) throws InterruptedException, IOException {
        String pathToYaml = new String("C:\\Users\\ruesteves\\Documents\\GitHub\\LuluPerfTest\\src\\main\\java\\com\\lulu\\main\\prototype\\DslPrototype.yml");
        DslParser parser = new DslParser(pathToYaml);
        parser.run();
    }
}
