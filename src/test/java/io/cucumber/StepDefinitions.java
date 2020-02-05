package io.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {

    public int cukes;

    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) {
        this.cukes = cukes;
        Belly belly = new Belly();
        System.out.println("QA given");
    }

    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int arg1) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("QA when");

    }
    @Then("^my belly should growl$")
    public void my_belly_should_growl() {

    }
}
