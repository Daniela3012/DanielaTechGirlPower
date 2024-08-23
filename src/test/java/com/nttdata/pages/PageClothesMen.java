package com.nttdata.pages;

public class PageClothesMen extends BasePage {
    private String product = "//img[@alt='Hummingbird printed t-shirt']";

    public PageClothesMen () {
        super();
    }

    public void clickOnProduct () {
        clickElement(product);
    }
}
