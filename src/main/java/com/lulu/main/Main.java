package com.lulu.main;

import com.lulu.main.java.models.dsl.DslRunner;

import java.io.IOException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws IOException {
        for (String s : args) {
            new DslRunner(new URL(s));
        }
    }
}
