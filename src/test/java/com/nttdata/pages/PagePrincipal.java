package com.nttdata.pages;

public class PagePrincipal extends BasePage {
    //Se esta obteniendo el Xpath
    private String btnLogin = "//span[normalize-space()='Iniciar sesión']";

    public PagePrincipal() {
        super();
    }

    public void navigateToStorePe () {
        navigateTo("https://qalab.bensg.com/store/pe/");
    }

    public void clickOnLogIn () {
        clickElement(btnLogin);
    }
}
