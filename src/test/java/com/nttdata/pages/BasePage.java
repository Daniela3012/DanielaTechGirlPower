package com.nttdata.pages;

import com.nttdata.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions action;

    public BasePage() {
        DriverManager driverManager = new DriverManager();
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(160));
        this.action = DriverManager.getAction();
    }

    public void navigateTo (String url) {
        driver.get(url);
    }

    private WebElement FindByXPath (String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public void hoverOverElement (String locator) {
        action.moveToElement(FindByXPath(locator)).perform();
    }

    public void hoverAndClickSubElement (String mainElementLocator, String subElementLocator) {
        hoverOverElement(mainElementLocator);

        // Esperar a que el subelemento sea visible antes de hacer clic
        WebElement subElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(subElementLocator)));
        subElement.click();
    }


    public String getText (String locator) {
        return FindByXPath(locator).getText();
    }

    public void clickElement (String locator) {
        FindByXPath(locator).click();
    }

    public void write (String locator, String text) {
        FindByXPath(locator).clear();
        FindByXPath(locator).sendKeys(text);
    }








}
