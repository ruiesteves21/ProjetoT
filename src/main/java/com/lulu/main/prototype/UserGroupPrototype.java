package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslParser;
import com.lulu.main.java.models.UserGroup;

import java.io.IOException;

public class UserGroupPrototype {
    public static void main(String[] args) throws InterruptedException, IOException {
       // URL pathToYaml = new URL("file:///C:/Users/ruesteves/Documents/GitHub/LuluPerfTest/src/main/java/com/lulu/main/prototype/DslPrototype.yml");
        String pathToYaml = new String("file:///C:/Users/ruesteves/Documents/GitHub/LuluPerfTest/src/main/java/com/lulu/main/prototype/DslPrototype.yml");
        DslParser parser = new DslParser(pathToYaml, pathToYaml);
        UserGroup userGroup = new UserGroup("default", parser.useCases);
        userGroup.runUseCases();
    }
}




