package com.nttdata.pages;

public class PageInventarioProducts extends BasePage{

    private String title = "//span[@class='title']";
    private String cardItem = "//div[@class='inventory_item']";
    private String product = "//a[.//div[text()='%s']]";

    public PageInventarioProducts () {
        super();
    }

    public String getTitle () {
        return getText(title);
    }
    public int countProducts () {
        return countAllElementsByXPath(cardItem);
    }
    public void clickOnProduct (String productName) {
        String xPathProduct = String.format(product, productName);
        clickElement(xPathProduct);
    }
}
