package com.lt.cucumber;

import com.lt.LTSerenityTest;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/onboard.feature")
public class Test1 extends LTSerenityTest {
}
