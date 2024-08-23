package com.nttdata.pages;

public class PageCart extends BasePage {
    private String titleCart = "//div[@class='card-block']/h1[@class='h1']";
    private String totalPrice = "//span[@class='product-price']";

    public PageCart () {
        super();
    }

    public String getTitleCart () {
        return getText(titleCart);
    }

    public String getTotalPrice () {
        return getText(totalPrice);
    }
}
