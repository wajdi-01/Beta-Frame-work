package com.BetaFrameWork.steps;

import com.BetaFrameWork.Base;
import com.BetaFrameWork.page.AlphaPage;
import com.BetaFrameWork.page.BetaPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.PageFactory;

public class AlphaSteps extends Base {


    AlphaPage alphaPage;
    public AlphaSteps() {
        PageFactory.initElements(driver, AlphaPage.class);
        this.alphaPage = new AlphaPage();
    }

    //**failed login**//
    @When("the user enters invalid username  and password")
    public void the_user_enters_invalid_username_and_password() {
        PageFactory.initElements(driver, AlphaPage.class );
        alphaPage.enterInvalidEmailAndPassword();
    }
    @And("clicks on the login button")
    public void clicks_the_login_button() {
        alphaPage.clicksTheLoginButton();
    }

    @Then("The error message should be displayed, indicating a failed login")
    public void the_error_message_should_be_displayed_indicating_a_failed_login() {
        alphaPage.failedLoginAssert();
    }
}
