package com.lt.cucumber.steps;

import org.openqa.selenium.JavascriptExecutor;

import com.lt.cucumber.pages.TelusApp;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.steps.ScenarioSteps;

public class TelusOnboard extends ScenarioSteps {
    TelusApp TelusApp;
    Scenario scenario;

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @When("I click on Skip")
    public void initiateonboarding() throws Throwable {
        // TelusApp.ClickEnterText();
        TelusApp.submitForm();
    }

    // @And("^I submit$")
    // public void thenSubmit() throws Throwable {
    //     Thread.sleep(5000);
    // }

    // @Then("^I should see results")
    // public void matchTitle() throws Throwable {
    //     TelusApp.thereShouldBeElements();
    // }

    @After
    public void getSessionDetails() {
        String name = scenario.getName();

    }
}
