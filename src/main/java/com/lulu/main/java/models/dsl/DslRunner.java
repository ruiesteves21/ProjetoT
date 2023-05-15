package com.lulu.main.java.models.dsl;

import java.io.IOException;
import java.io.InputStream;

public class DslRunner {
    public DslParser parser;

    public DslRunner(InputStream pathToYaml, InputStream pathToAuxYaml) {
        this.parser = new DslParser(pathToYaml, pathToAuxYaml);
        try {
            this.parser.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
