package com.BetaFrameWork;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com/BetaFrameWork",
        tags = "@TestTow",
        plugin = {"pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm","html:target/report.html"},

        //"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        stepNotifications = true

)
public class TestRunner {

}