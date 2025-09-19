package org.taib.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.taib.pom.base.BasePage;

public class StorePage extends BasePage {
    private final By searchField = By.cssSelector("input[type=\"search\"][id=\"woocommerce-product-search-field-0\"]");
    private final By searchButton = By.cssSelector("button[type=\"submit\"][value=\"Search\"]");
    private final By searchTitle = By.cssSelector("[class=\"woocommerce-products-header__title page-title\"]");
    private final By blueShoeImage = By.cssSelector("div>a[href=\"https://askomdch.com/product/blue-shoes/\"]>img");
    private final By addToCart = By.cssSelector("[type=\"submit\"]");
    private final By viewCartButton = By.cssSelector("div[role='alert'] a[class='button wc-forward']");
    private final By checkoutButton = By.cssSelector("a[href=\"https://askomdch.com/checkout/\"]");

    public StorePage(WebDriver driver) {
        super(driver);
    }


    public StorePage searchForProduct(String productName) {
        driver.findElement(searchField).sendKeys(productName);
        return this;
    }

    public StorePage clickSearchButton() {
        driver.findElement(searchButton).click();
        return this;
    }

    public String getSearchTitleText() {
        return driver.findElement(searchTitle).getText();
    }

    public void clickBlueShoeImage() {
        driver.findElement(blueShoeImage).click();
    }

    public void clickAddToCart() {
        driver.findElement(addToCart).click();
    }

    public StorePage clickViewCart() {
        driver.findElement(viewCartButton).click();
        return this;
    }

    public CheckoutPage clickCheckout() {
        driver.findElement(checkoutButton).click();
        return new CheckoutPage(driver);
    }
}
