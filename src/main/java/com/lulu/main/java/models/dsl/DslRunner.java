package com.lulu.main.java.models.dsl;

import java.io.IOException;

public class DslRunner {
    public DslParser parser;

    public DslRunner(String pathToYaml, String pathToAuxYaml) throws IOException {
        this.parser = new DslParser(pathToYaml, pathToAuxYaml);
        try {
            this.parser.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
