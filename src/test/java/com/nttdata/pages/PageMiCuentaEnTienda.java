package com.nttdata.pages;

import org.openqa.selenium.By;

public class PageMiCuentaEnTienda extends BasePage {

    public static By categoriaClothes = By.cssSelector("a[href*='/3-clothes']");


    // Puedes agregar más selectores según sea necesario
    // public static By otraCategoria = By.cssSelector("...");

    public void clickOnCategoria(String categoriaName) {
        driver.findElement(categoriaClothes).click();
    }


}
