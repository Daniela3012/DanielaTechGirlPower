package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ScreenSauceLogin extends PageObject {
    public ScreenSauceLogin() {
        PageFactory.initElements(new AppiumFieldDecorator(getDriver()), this);
    }


    @AndroidFindBy(xpath = "//android.widget.EditText[@content-desc=\"test-Username\"]")
    private WebElement inputUser;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[2]")
    private WebElement inputPassword;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
    private WebElement btnLogin;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")
    private WebElement tituloApp;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"test-Item\"]")
    private List<WebElement> listaSecond;


    public void ingresarUsuario(String texto){
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.elementToBeClickable(inputUser));

        waitFor(ExpectedConditions.elementToBeClickable(inputUser));


        inputPassword.sendKeys(texto);
    }


    public void ingresarClave(String arg0) {
        inputPassword.sendKeys(arg0);
    }

    public void ingresar() {
        btnLogin.click();
    }
    public int getCountElements(){
        return listaSecond.size();
    }

//
    public String getTitulo() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart drop zone\"]/android.view.ViewGroup/android.widget.TextView")));
        return tituloApp.getText();


    }
}
