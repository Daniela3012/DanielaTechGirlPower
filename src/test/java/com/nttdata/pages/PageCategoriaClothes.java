package com.nttdata.pages;

import org.openqa.selenium.By;

public class PageCategoriaClothes extends BasePage {
    private static By subCategoriaMen = By.cssSelector("body main section[id='wrapper'] li li:nth-child(1) a:nth-child(1)");
    private static By subCategoriaWomen = By.cssSelector("body main section[id='wrapper'] li li:nth-child(2) a:nth-child(1)");

    public PageCategoriaClothes() {
        super();
    }

    // Método para hacer clic en una subcategoría específica
    public void clickOnSubCategory(String subCategoryName) {
        switch (subCategoryName.toLowerCase()) {
            case "men":
                driver.findElement(subCategoriaMen).click();
                break;
            case "women":
                driver.findElement(subCategoriaWomen).click();
                break;
            default:
                throw new IllegalArgumentException("Subcategoría no soportada: " + subCategoryName);
        }
    }
}
