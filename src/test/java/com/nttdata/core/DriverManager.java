package com.nttdata.core;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static WebDriver driver;
    private static Scenario scenario;

    // Método para inicializar el WebDriver
    @Before
    public void setUp(Scenario scenario) {
        DriverManager.scenario = scenario; // Guardar el escenario actual
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    // Método para cerrar el WebDriver
    @After
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Método para obtener el WebDriver
    public static WebDriver getDriver() {
        return driver;
    }

    // Método para obtener el Scenario
    public static Scenario getScenario() {
        return scenario;
    }
}
