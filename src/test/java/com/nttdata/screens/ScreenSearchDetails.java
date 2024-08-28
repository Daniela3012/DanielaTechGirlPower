package com.nttdata.screens;

import io.appium.java_client.pagefactory.AndroidFindBy;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.WebElement;

public class ScreenSearchDetails extends PageObject {

    @AndroidFindBy(id="search_input")
    private WebElement inputSearchDetail;

    @AndroidFindBy(id="2131429999")
    private WebElement inputTextSearchDetail;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.view.ViewGroup/android.view.ViewGroup/androidx.recyclerview.widget.RecyclerView/android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView")
    private WebElement btnFirstOption;

    @AndroidFindBy(id = "2131430997")
    private WebElement btnNext;

    @AndroidFindBy(id = "2131430822")
    private WebElement btnSearch;

    public void enterSearchInput(String place){
        inputSearchDetail.click();
        inputTextSearchDetail.sendKeys(place);
    }

    public void clickFirstOption(){
        btnFirstOption.click();
    }

    public void clickNext(){
        btnNext.click();
    }

    public void clickSearch(){
        btnSearch.click();
    }




}
