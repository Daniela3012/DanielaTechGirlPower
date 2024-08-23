package com.nttdata.pages;

public class PageProduct_TShirtRed extends BasePage {
    private String titleProduct = "//div[@class='inventory_details_name large_size']";
    private String btnAddToCart = "//button[@id='add-to-cart']";

    public PageProduct_TShirtRed () {
        super();
    }

    public void getTitleProduct () {
        getText(titleProduct);
    }

    public void clickOnAddToCart () {
        clickElement(btnAddToCart);
    }

}
