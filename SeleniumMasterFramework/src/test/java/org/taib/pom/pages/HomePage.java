package org.taib.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.taib.pom.base.BasePage;

public class HomePage extends BasePage {
    private final By storeMenuLink = By.cssSelector("#menu-item-1227 > a");



    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage load(){
        load("/");
        return this;
    }

    public StorePage clickOnStoreMenuLink(){
        driver.findElement(storeMenuLink).click();
        return new StorePage(driver);
    }

}
