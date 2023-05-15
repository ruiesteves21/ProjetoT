package com.lulu.main.prototype;

import com.lulu.main.java.models.dsl.DslParser;
import com.lulu.main.java.models.UserGroup;

import java.io.IOException;
import java.io.InputStream;

public class UserGroupPrototype {
    public static void main(String[] args) throws InterruptedException, IOException {
        String dslYamlPath = "DslPrototype.yml";
        String toolYamlPath = "ToolPrototype.yml";
        ClassLoader classLoader = RunnerPrototype.class.getClassLoader();
        InputStream dslYamlStream = classLoader.getResourceAsStream(dslYamlPath);
        InputStream toolYamlStream = classLoader.getResourceAsStream(toolYamlPath);
        DslParser parser = new DslParser(dslYamlStream, toolYamlStream);
        UserGroup userGroup = new UserGroup("default", parser.useCases);
        userGroup.runUseCases();
    }
}




