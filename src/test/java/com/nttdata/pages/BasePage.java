package com.nttdata.pages;

import com.nttdata.core.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        DriverManager driverManager = new DriverManager();
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    }

    public void navigateTo (String url) {
        driver.get(url);
    }

    private WebElement FindByXPath (String locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    public int countAllElementsByXPath (String locator) {
        List<WebElement> allElements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(locator)));
        return allElements.size();
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

    public void selectFromDropdownByValue (String locator, String value) {
        Select dropdown = new Select(FindByXPath(locator));
        dropdown.selectByValue(value);
    }

    public void selectFromDropdownByIndex (String locator, int index) {
        Select dropdown = new Select(FindByXPath(locator));
        dropdown.selectByIndex(index);
    }

    public int dropDownSize (String locator) {
        Select dropdown = new Select(FindByXPath(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        return dropdownOptions.size();
    }

    public List<String>getDropdownValues (String locator) {
        Select dropdown = new Select(FindByXPath(locator));
        List<WebElement> dropdownOptions = dropdown.getOptions();
        List<String> dropdownValues = new ArrayList<>();
        for (WebElement valueOption : dropdownOptions) {
            dropdownValues.add(valueOption.getText());
        }
        return dropdownValues;
    }

}
