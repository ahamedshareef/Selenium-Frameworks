package org.taib.pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.taib.pom.base.BasePage;
import org.taib.pom.objects.BillingAddress;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private final By billingFirstName = By.cssSelector("[name=\"billing_first_name\"]");
    private final By billingLastName = By.cssSelector("[name=\"billing_last_name\"]");
    private final By billingCountryDropdown = By.cssSelector("[id=\"select2-billing_country-container\"]");
    private final By billingCountryOption = By.xpath("//li[text()=\"United States (US)\"]");
    private final By billingAddress1 = By.cssSelector("[id=\"billing_address_1\"]");
    private final By billingCity = By.cssSelector("[name=\"billing_city\"]");
    private final By billingStateDropdown = By.cssSelector("[id=\"select2-billing_state-container\"]");
    private final By billingStateOption = By.xpath("//li[text()=\"Alaska\"]");
    private final By billingEmail = By.cssSelector("[name=\"billing_email\"]");
    private final By billingPostcode = By.cssSelector("[name=\"billing_postcode\"]");
    private final By placeOrderButton = By.cssSelector("[name=\"woocommerce_checkout_place_order\"]");
    private final By thankYouText = By.xpath("//p[contains(text(),\"Thank you\")]");
    private final By showLoginLink = By.cssSelector("a.showlogin");
    private final By usernameField = By.name("username");
    private final By passwordField = By.id("password");


    public void enterBillingDetails(BillingAddress billingAddress){
        enterBillingFirstName(billingAddress.getFirstName());
        enterBillingLastName(billingAddress.getLastName());
        clickBillingCountryDropdown();
        selectBillingCountry();
        enterBillingAddress1(billingAddress.getStreetAddress());
        enterBillingCity(billingAddress.getCity());
        clickBillingStateDropdown();
        selectBillingState();
        enterBillingEmail(billingAddress.getEmailAddress());
        enterBillingPostcode(billingAddress.getZipCode());
    }


    public void enterBillingFirstName(String firstName) {
        driver.findElement(billingFirstName).sendKeys(firstName);
    }

    public void enterBillingLastName(String lastName) {
        driver.findElement(billingLastName).sendKeys(lastName);
    }

    public void clickBillingCountryDropdown() {
        driver.findElement(billingCountryDropdown).click();
    }

    public void selectBillingCountry() {
        driver.findElement(billingCountryOption).click();
    }

    public void enterBillingAddress1(String address) {
        driver.findElement(billingAddress1).sendKeys(address);
    }

    public void enterBillingCity(String city) {
        driver.findElement(billingCity).sendKeys(city);
    }

    public void clickBillingStateDropdown() {
        driver.findElement(billingStateDropdown).click();
    }

    public void selectBillingState() {
        driver.findElement(billingStateOption).click();
    }

    public void enterBillingEmail(String email) {
        driver.findElement(billingEmail).sendKeys(email);
    }

    public void enterBillingPostcode(String postcode) {
        driver.findElement(billingPostcode).sendKeys(postcode);
    }

    public void clickPlaceOrder() {
        driver.findElement(placeOrderButton).click();
    }

    public String getThankYouText() {
        return driver.findElement(thankYouText).getText();
    }

    public void clickShowLogin() {
        driver.findElement(showLoginLink).click();
    }

    public void login(String username, String password) {
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clearBillingEmail() {
        driver.findElement(billingEmail).clear();
    }
}
