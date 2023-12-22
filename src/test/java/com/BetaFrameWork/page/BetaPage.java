package com.BetaFrameWork.page;

import com.BetaFrameWork.utils.Base;
import com.BetaFrameWork.utils.ConfigUtils;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

public class BetaPage extends Base {


    //**FindBy**//
    @FindBy(xpath = "//input[@id='email']")
    public static WebElement emailBox;
    @FindBy(xpath = "//input[@id='password']")
    public static WebElement passwordBox;
    @FindBy(xpath = "//button[@id='submit']")
    public static WebElement loginButton;
    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    public static WebElement logoutBtnAssert;
    @FindBy(xpath = "//div[contains(text(),'We could not find the email in the database')]")
    public static WebElement invalidUserName;


    @FindBy(xpath = "//span[@class='MuiIconButton-label']//*[name()='svg']")
    public static WebElement addButton;
    @FindBy(xpath = "//input[@type='text']")
    public static WebElement todoItem;
    @FindBy(xpath = "//div[@class='sc-kgflAQ eoofHA']//button[@type='button']")
    public static WebElement createTodoButton;
    @FindBy(xpath = "//div[@class='sc-breuTD dIVhJd']")
    public static WebElement addTodoAssert;
    @FindBy(xpath = "//div[@role='alert']")
    public static WebElement failedLoginErrorMessage;




    //**Methods**//

    public void entersValidUsernameAndPassword() {
        emailBox.sendKeys("qatest@gmail.com");
        passwordBox.sendKeys("Wajdi.17");
    }
    public void clicksTheLoginButton() {
        loginButton.click();
    }
    public void successfulLoginAssert() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        Assert.assertTrue(logoutBtnAssert.isDisplayed());
    }
    public void loadUrl() {
        String baseUrl = ConfigUtils.getInstance().getBaseUrl();
        driver.get(baseUrl);

    }

    public void entersInvalidUsernameAndPassword() {
        emailBox.sendKeys("ABCD1234@gmail.com");
        passwordBox.sendKeys("Test.102030");
    }
    public void invalidUserNameErrorMessageAssert() {
        Assert.assertTrue("Error message is Not Displayed ! ",invalidUserName.isDisplayed());
    }


    public void clickOnAddButton() {
        addButton.click();
    }
    public void fillTodoItem() {
        todoItem.sendKeys("New Todo");
    }
    public void clickOnCreateTodoButton() {
        createTodoButton.click();
    }
    public void addTodoSuccessfullyAssert() {
        Assert.assertTrue(addTodoAssert.isDisplayed());
        String newTodoItem = addTodoAssert.getText();
        Assert.assertEquals("New Todo", newTodoItem);


    }
    public void enterInvalidEmailAndPassword() {
        emailBox.sendKeys("qatest@gmail.com");
        passwordBox.sendKeys("Test.1234567");
    }
    public void failedLoginAssert() {
        Assert.assertTrue(failedLoginErrorMessage.isDisplayed());
    }
}
