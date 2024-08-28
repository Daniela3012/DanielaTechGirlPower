package com.nttdata.stepsdefinitions;

import com.nttdata.steps.LoginSauceLabsSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginSauceLabsStepDef {
    private static final Logger log = LoggerFactory.getLogger(LoginSauceLabsStepDef.class);
    @Steps
    LoginSauceLabsSteps login;



    @When("inicio sesión con el usuario {string} y clave {string}")
    public void inicioSesiónConElUsuarioYClave(String userName, String password) {
        login.typeUserName(userName);
        login.typePassword(password);
    }

    @Given("ingreso al aplicativo de SauceLabs")
    public void ingresoAlAplicativoDeSauceLabs() {
    }

    @When("ingreso el usuario {string}")
    public void ingresoConElUsuario(String userName) {
        login.typeUserName(userName);
    }

    @And("ingreso la clave {string}")
    public void ingresoLaClave(String password) {
        login.typePassword(password);
    }

    @And("hago click en el boton Login")
    public void hagoClickEnElBotonLogin() {
        login.clickToLogin();
    }

    @Then("valido el ingreso correctamente")
    public void validoElIngresoCorrectamente() {
        login.validacionLogin();
    }

}
