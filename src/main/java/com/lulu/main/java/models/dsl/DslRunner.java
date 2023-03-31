package com.lulu.main.java.models.dsl;

import java.io.IOException;

public class DslRunner {
    public DslParser parser;

    public DslRunner(String pathToScript) throws IOException {
        this.parser = new DslParser(pathToScript);
        try {
            this.parser.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
