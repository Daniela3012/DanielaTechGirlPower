package com.nttdata.core;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;
    private static Actions action;

    @Before
    public void setUp(Scenario scenario) {
        DriverManager.scenario = scenario; // Guardar el escenario actual
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        DriverManager.action = new Actions(driver);
    }

    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


    public static WebDriver getDriver() {
        return driver;
    }


    public static Scenario getScenario() {
        return scenario;
    }

    public static Actions getAction() {return action; }
}
