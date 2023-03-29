package com.lt;


import java.util.Map;
import java.util.HashMap;

import org.junit.BeforeClass;
import org.junit.AfterClass;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;

public class LTSerenityTest {

    @BeforeClass
    public static void setUp() throws Exception {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String accessKey = System.getenv("LT_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) environmentVariables.getProperty("lt.key");
        }

        String environment = System.getProperty("environment");
    
    }

    @AfterClass
    public static void tearDown() throws Exception {
    }
}
