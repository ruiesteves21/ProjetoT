package com.lulu.main;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        for (String s : args) {
            new DslRunner(s, args[1]);
        }
    }
}
