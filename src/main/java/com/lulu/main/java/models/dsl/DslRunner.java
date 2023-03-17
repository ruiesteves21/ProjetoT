package com.lulu.main.java.models.dsl;

import java.io.IOException;
import java.net.URL;

public class DslRunner {
    public DslParser parser;
    public DslRunner(URL pathToScript) throws IOException {
        this.parser = new DslParser(pathToScript);
        try {
            this.parser.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
