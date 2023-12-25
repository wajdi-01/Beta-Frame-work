package com.BetaFrameWork.steps;

import com.BetaFrameWork.utils.Base;
import com.BetaFrameWork.page.BetaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import org.openqa.selenium.support.PageFactory;

public class BetaSteps extends Base {

    BetaPage betaPage;
    public BetaSteps() {
        PageFactory.initElements(driver, BetaPage.class );
        this.betaPage = new BetaPage();
    }

    //**Successful Login**//
    @Description("Environnement : Windows 10, Chrome 99")
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        PageFactory.initElements(driver, BetaPage.class );
        lunchBrowser();
        betaPage.loadUrl();
    }
    @When("the user enters valid username  and password")
    public void the_user_enters_valid_username_and_password() {
        PageFactory.initElements(driver, BetaPage.class );
        betaPage.entersValidUsernameAndPassword();
    }
    @And("clicks the login button")
    public void clicks_the_login_button() {
        betaPage.clicksTheLoginButton();
    }
    @Then("the user should be redirected to the dashboard")
    public void the_user_should_be_redirected_to_the_dashboard() {
    betaPage.successfulLoginAssert();
       System.out.println("Assert step !");
    }

    //**Failed Login**//
    @When("the user enters invalid username  and password")
    public void the_user_enters_invalid_username_and_password() {
        PageFactory.initElements(driver, BetaPage.class );
        betaPage.entersInvalidUsernameAndPassword();
    }
    @Then("an error message should be displayed")
    public void an_error_message_should_be_displayed() {
    betaPage.invalidUserNameErrorMessageAssert();
    }


    //**Add a todo**//
    @When("the user clicks on the PLUS button")
    public void the_user_clicks_on_the_plus_button() {
    betaPage.clickOnAddButton();
    }
    @When("adds a new todo with a title")
    public void adds_a_new_todo_with_a_title() {
    betaPage.fillTodoItem();
    }
    @When("the user clicks on CREATE TODO button")
    public void the_user_clicks_on_create_todo_button() {
    betaPage.clickOnCreateTodoButton();
    }
    @Then("the todo should be added successfully")
    public void the_todo_should_be_added_successfully() {
    betaPage.addTodoSuccessfullyAssert();
    }




}
