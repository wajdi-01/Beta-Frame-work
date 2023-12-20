package com.BetaFrameWork.steps;

import com.BetaFrameWork.Base;
import com.BetaFrameWork.page.BetaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class BetaSteps extends Base {

    BetaPage betaPage;
    public BetaSteps() {
        PageFactory.initElements(driver, BetaPage.class );
        this.betaPage = new BetaPage();
    }


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
}
