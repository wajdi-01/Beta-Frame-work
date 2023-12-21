package com.BetaFrameWork.page;

import com.BetaFrameWork.Base;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlphaPage extends Base {


    //**FindBy**//
    @FindBy(xpath = "//input[@id='email']")
    public static WebElement emailBox;
    @FindBy(xpath = "//input[@id='password']")
    public static WebElement passwordBox;
    @FindBy(xpath = "//button[@id='submit']")
    public static WebElement loginButton;
    @FindBy(xpath = "//div[@role='alert']")
    public static WebElement failedLoginErrorMessage;




    //**Methods**//
    public void enterInvalidEmailAndPassword() {
        emailBox.sendKeys("qatest@gmail.com");
        passwordBox.sendKeys("Test.1234567");
    }
    public void clicksTheLoginButton() {
        loginButton.click();
    }
    public void failedLoginAssert() {
        Assert.assertTrue(failedLoginErrorMessage.isDisplayed());
        String loginFailedErrorMessage = failedLoginErrorMessage.getText();
        Assert.assertEquals("The error message is not displayed !","The email and password combination is not correct, please fill a correct email and password", loginFailedErrorMessage);
    }

}
