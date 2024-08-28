package com.nttdata.steps;

import com.nttdata.screens.ScreenSauceLogin;
import org.junit.Assert;

public class LoginSauceLabsSteps {
    ScreenSauceLogin login;

    public void typeUserName(String usuario) {
        login.ingresarUsuario(usuario);
    }

    public void typePassword(String arg0) {
        login.ingresarClave(arg0);
    }

    public void clickToLogin() {
        login.ingresar();
    }

    public void validacionLogin() {
        Assert.assertEquals("PRODUCTS",login.getTitulo() );
        Assert.assertTrue(login.getCountElements()>1);

    }
}
