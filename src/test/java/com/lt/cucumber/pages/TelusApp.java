package com.lt.cucumber.pages;

import static org.assertj.core.api.Assertions.assertThat;

import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class TelusApp extends MobilePageObject {
    public TelusApp(WebDriver driver) {
        super(driver);
    }

    // @AndroidFindBy(accessibility = "Search Wikipedia")
    // WebElement searchButton;

    @AndroidFindBy(id = "com.telus.mywifi:id/tv_skip")
    WebElement skip;

    @AndroidFindBy(id = "com.telus.mywifi:id/location_tq")
    WebElement region;

    @AndroidFindBy(id = "com.telus.mywifi:id/button_continue")
    WebElement cont;

    @AndroidFindBy(id = "com.telus.mywifi:id/terms_checkbox")
    WebElement checkbox;
    
    @AndroidFindBy(id = "com.telus.mywifi:id/terms_agree")
    WebElement agree;
    

    // public void ClickEnterText() throws Exception {
    //     element(skip).click();
    //     Thread.sleep(5000);
    // }

    public void submitForm() throws Exception{
        Thread.sleep(10000);
        element(skip).click();
        Thread.sleep(3000);

        element(region).click();
        Thread.sleep(2000);

        element(cont).click();
        Thread.sleep(2000);
        
        element(checkbox).click();

        Thread.sleep(2000);
        
        element(agree).click();
        
    }
    

    public void thereShouldBeElements() {
        List allProductsName = getDriver().findElements(MobileBy.className("android.widget.TextView"));
        assertThat((allProductsName)).isNotEmpty();
    }
}
