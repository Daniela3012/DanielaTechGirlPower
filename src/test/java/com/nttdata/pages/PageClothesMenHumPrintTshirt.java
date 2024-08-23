package com.nttdata.pages;

public class PageClothesMenHumPrintTshirt extends BasePage {
    private String btnAddCountThirt = "//i[@class='material-icons touchspin-up']";
    private String btnAddCart = "//button[@class='btn btn-primary add-to-cart']";
    private String confirmationMessage = "//h4[@class='modal-title h6 text-sm-center' and @id='myModalLabel']";
    private String totalPrice = "//p[@class='product-total']/span[@class='value']";
    private String btnEndBuy = "//a[@class='btn btn-primary' and contains(text(), 'Finalizar compra')]";
    private String btnCart = "//span[normalize-space()='Carrito']";

    public PageClothesMenHumPrintTshirt () {
        super();
    }

    public void clickOnAddTshirt (int quantity) {
        for (int i = 0; i < quantity; i++) {
            clickElement(btnAddCountThirt);
        }
    }

    public void clickOnAddCart () {
        clickElement(btnAddCart);
    }

    public String getConfirmationMessage () {
        String actualText = getText(confirmationMessage);

        // Limpia el texto eliminando caracteres no alfanuméricos
        String cleanedText = actualText.replaceAll("[^\\p{L}\\p{N}\\s]", "").trim();
        return cleanedText;
    }

    public String getTotalPrice () {
        return getText(totalPrice);
    }

    public void clickOnEndBuy () {
        clickElement(btnEndBuy);
    }

    public void clickOnCart () {
        clickElement(btnCart);
    }

}
