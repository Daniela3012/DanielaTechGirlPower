package com.nttdata.steps;

import com.nttdata.screens.ScreenLogin;
import com.nttdata.screens.ScreenSearchDetails;
import com.nttdata.screens.ScreenSearch;
import net.thucydides.core.annotations.Step;


public class AirbnbSearchSteps {

    ScreenLogin pantallaDeLogin;
    ScreenSearch pantallaDeBusqueda;
    ScreenSearchDetails pantallaDeDetalles;

    @Step("Click en cerrar")
    public void clickClose(){
        pantallaDeLogin.clickClose();
    }

    @Step("Búsqueda por texto {string}")
    public void searchByText(String place){
        pantallaDeBusqueda.clickSearchInput();
        pantallaDeDetalles.enterSearchInput(place);
        pantallaDeDetalles.clickFirstOption();
        pantallaDeDetalles.clickNext();
        pantallaDeDetalles.clickSearch();
    }

    @Step("Obtiene el texto del resultado")
    public String getResultText(){
        return pantallaDeBusqueda.getResultText();
    }
}
