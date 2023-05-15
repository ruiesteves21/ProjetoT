package com.lulu.main;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(InputStream[] args) throws IOException {
        for (InputStream s : args) {
            new DslRunner(s, args[1]);
        }
    }
}
