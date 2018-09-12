package com.stepdefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DebugStepDefs extends BaseStepDefs {

    @When("^user navigates to Login Page$")
    public void user_navigates_to_Login_Page() {
        loginPage.goToLogin();
    }

    @When("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_username_and_Password(String user, String pass) {
        loginPage.doLogin(user,pass);
    }

    @Then("^success message is displayed$")
    public void success_message_is_displayed() {
        loginPage.checkInfo();
    }
}
