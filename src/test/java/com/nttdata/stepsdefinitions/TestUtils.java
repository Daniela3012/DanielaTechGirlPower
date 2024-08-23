package com.nttdata.stepsdefinitions;

import io.cucumber.java.Scenario;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.nttdata.core.DriverManager;
import org.openqa.selenium.WebDriver;

public class TestUtils {

    // Método para tomar capturas de pantalla
    public static void takeScreenShot() {
        WebDriver driver = DriverManager.getDriver();
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        DriverManager.getScenario().attach(screenshot, "image/png", "screenshot");
    }

    // Método para hacer scroll hacia abajo
    public static void scrollDown() {
        WebDriver driver = DriverManager.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
    }
}