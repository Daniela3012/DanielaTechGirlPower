package com.nttdata.pages;

public class PageLoginSaucedemo extends BasePage {

    private String userInput = "//input[@id='user-name']";
    private String passInput = "//input[@id='password']";
    private String btnLogin = "//input[@id='login-button']";

    public PageLoginSaucedemo () {
        super();
    }

    public void navigateToSaucedemo () {
        navigateTo("https://www.saucedemo.com/");
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
