package com.BetaFrameWork.steps;

import com.BetaFrameWork.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ViewportPastingDecorator;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class Hooks extends Base {
    @Before
    public void runsBeforeAnyScenario() {

    }

    @After
    public void runsAfterAnyScenario(Scenario scenario) throws IOException {
        // Take a screenshot of the whole web page
        BufferedImage image = new AShot()
                .shootingStrategy(new ViewportPastingDecorator(ShootingStrategies.scaling(1.0f)))
                .takeScreenshot(driver)
                .getImage();

        // Convert the screenshot to bytes
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        byte[] screenshot = baos.toByteArray();

        // Attach the screenshot to the scenario
        scenario.attach(screenshot, "image/png", "image");

        // Quit the driver
        driver.quit();
    }

}
