package com.nttdata.pages;

public class PageLogin extends BasePage{

    private String userInput = "//input[@id='field-email']";
    private String passInput = "//input[@id='field-password']";
    private String btnLogin = "//button[@id='submit-login']";

    public PageLogin () {
        super();
    }


    public void typeUserInput (String username) {
        write(userInput, username);
    }

    public void typePassInput (String password) {
        write(passInput, password);
    }

    public void clickOnLogin () {
        clickElement(btnLogin);
    }
}
