package org.taib;

import org.openqa.selenium.By;
import org.taib.pom.base.BaseTest;
import org.taib.pom.objects.BillingAddress;
import org.taib.pom.pages.HomePage;
import org.taib.pom.pages.StorePage;
import org.taib.pom.pages.CheckoutPage;
import org.taib.pom.utils.JacksonUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class FirstTest extends BaseTest {

    @Test
    public void checkoutBlueGuestLogin() throws InterruptedException {

        BillingAddress billingaddress = new BillingAddress();
        billingaddress.setFirstName("Shangi");
        billingaddress.setLastName("Mangi");
        billingaddress.setCountry("United States (US)");
        billingaddress.setStreetAddress("Dubai Kuruku Sandu");;
        billingaddress.setCity("Chikago");
        billingaddress.setState("Alaska");
        billingaddress.setEmailAddress("shangi.mangi@gmail.com");
        billingaddress.setZipCode("99619");

        StorePage storePage = new HomePage(driver)
                .load()
                .clickOnStoreMenuLink();
//        StorePage storePage = homePage.clickOnStoreMenuLink();
        storePage.searchForProduct("Blue").clickSearchButton();
        //storePage.clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getSearchTitleText(),"Search results: “Blue”");
        storePage.clickBlueShoeImage();
        storePage.clickAddToCart();

        Thread.sleep(4000);
        storePage.clickViewCart();
        CheckoutPage checkoutPage = storePage.clickCheckout();
        Thread.sleep(3000);

        checkoutPage.enterBillingFirstName("Shangi");
        checkoutPage.enterBillingLastName("Mangi");
        checkoutPage.clickBillingCountryDropdown();
        Thread.sleep(3000);
        checkoutPage.selectBillingCountry();
        checkoutPage.enterBillingAddress1("Dubai Kuruku Sandu");
        checkoutPage.enterBillingCity("Chikago");
        checkoutPage.clickBillingStateDropdown();
        Thread.sleep(3000);
        checkoutPage.selectBillingState();
        checkoutPage.enterBillingEmail("shangi.mangi@gmail.com");
        checkoutPage.enterBillingPostcode("99619");
        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getThankYouText(),
        "Thank you. Your order has been received.");



    }


    @Test
    public void checkoutBlueShoeRegisteredUser() throws InterruptedException {
        HomePage homePage = new HomePage(driver)
                .load();
        homePage.clickOnStoreMenuLink();
        StorePage storePage = new StorePage(driver);

        storePage.searchForProduct("Blue").clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getSearchTitleText(),"Search results: “Blue”");
        storePage.clickBlueShoeImage();
        storePage.clickAddToCart();
        Thread.sleep(3000);
        storePage.clickViewCart();
        CheckoutPage checkoutPage = storePage.clickCheckout();
        checkoutPage.clickShowLogin();
        Thread.sleep(3000);
        checkoutPage.login("shangi.mangi@gmail.com", "Test@123");
        Thread.sleep(3000);
        checkoutPage.enterBillingFirstName("Shangi");
        checkoutPage.enterBillingLastName("Mangi");
        checkoutPage.clickBillingCountryDropdown();
        Thread.sleep(3000);
        checkoutPage.selectBillingCountry();
        checkoutPage.enterBillingAddress1("Dubai Kuruku Sandu");
        checkoutPage.enterBillingCity("Chikago");
        checkoutPage.clickBillingStateDropdown();
        Thread.sleep(3000);
        checkoutPage.selectBillingState();
        checkoutPage.clearBillingEmail();
        checkoutPage.enterBillingEmail("shangi.mangi@gmail.com");
        checkoutPage.enterBillingPostcode("99619");
        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getThankYouText(),
                "Thank you. Your order has been received.");
    }



    @Test
    public void pojoBlueGuestLogin() throws InterruptedException {

        BillingAddress billingaddress = new BillingAddress()
                .setFirstName("Shangi")
                .setLastName("Mangi")
                .setCountry("United States (US)")
                .setStreetAddress("Dubai Kuruku Sandu")
                .setCity("Chikago")
                .setState("Alaska")
                .setEmailAddress("shangi.mangi@gmail.com")
                .setZipCode("99619");

        StorePage storePage = new HomePage(driver)
                .load()
                .clickOnStoreMenuLink();
//        StorePage storePage = homePage.clickOnStoreMenuLink();
        storePage.searchForProduct("Blue").clickSearchButton();
        //storePage.clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getSearchTitleText(),"Search results: “Blue”");
        storePage.clickBlueShoeImage();
        storePage.clickAddToCart();

        Thread.sleep(4000);
        storePage.clickViewCart();
        CheckoutPage checkoutPage = storePage.clickCheckout();
        Thread.sleep(3000);

        checkoutPage.enterBillingDetails(billingaddress); // POJO usage here

        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getThankYouText(),
                "Thank you. Your order has been received.");



    }


    @Test
    public void pojoConstructorGuestLogin() throws InterruptedException, IOException {

        BillingAddress billingaddress = new BillingAddress(
                "Shangi",
                "Mangi",
                "United States (US)",
                "Dubai Kuruku Sandu",
                "Chikago",
                "Alaska",
                "99619",
                "shangi.mangi@gmail.com");


        StorePage storePage = new HomePage(driver)
                .load()
                .clickOnStoreMenuLink();
//        StorePage storePage = homePage.clickOnStoreMenuLink();
        storePage.searchForProduct("Blue").clickSearchButton();
        //storePage.clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getSearchTitleText(),"Search results: “Blue”");
        storePage.clickBlueShoeImage();
        storePage.clickAddToCart();

        Thread.sleep(4000);
        storePage.clickViewCart();
        CheckoutPage checkoutPage = storePage.clickCheckout();
        Thread.sleep(3000);

        checkoutPage.enterBillingDetails(billingaddress); // POJO usage here

        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getThankYouText(),
                "Thank you. Your order has been received.");



    }


    @Test
    public void jacksonConstructorGuestLogin() throws InterruptedException, IOException {


        // JackSon usage
        BillingAddress billingAddress = new BillingAddress();
        InputStream is = getClass().getClassLoader().getResourceAsStream("MyBilling.json");
        billingAddress= JacksonUtils.deserializeBillingAddress(is,billingAddress);


        StorePage storePage = new HomePage(driver)
                .load()
                .clickOnStoreMenuLink();
//        StorePage storePage = homePage.clickOnStoreMenuLink();
        storePage.searchForProduct("Blue").clickSearchButton();
        //storePage.clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getSearchTitleText(),"Search results: “Blue”");
        storePage.clickBlueShoeImage();
        storePage.clickAddToCart();

        Thread.sleep(4000);
        storePage.clickViewCart();
        CheckoutPage checkoutPage = storePage.clickCheckout();
        Thread.sleep(3000);

        checkoutPage.enterBillingDetails(billingAddress); // POJO usage here

        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getThankYouText(),
                "Thank you. Your order has been received.");


    }



    @Test
    public void jacksonCommonLogin() throws InterruptedException, IOException {


        // JackSon usage using common method
        BillingAddress billingAddress = JacksonUtils.deserialize("MyBilling.json",BillingAddress.class);


        StorePage storePage = new HomePage(driver)
                .load()
                .clickOnStoreMenuLink();
//        StorePage storePage = homePage.clickOnStoreMenuLink();
        storePage.searchForProduct("Blue").clickSearchButton();
        //storePage.clickSearchButton();
        Thread.sleep(3000);
        Assert.assertEquals(storePage.getSearchTitleText(),"Search results: “Blue”");
        storePage.clickBlueShoeImage();
        storePage.clickAddToCart();

        Thread.sleep(4000);
        storePage.clickViewCart();
        CheckoutPage checkoutPage = storePage.clickCheckout();
        Thread.sleep(3000);

        checkoutPage.enterBillingDetails(billingAddress); // POJO usage here

        checkoutPage.clickPlaceOrder();
        Thread.sleep(3000);
        Assert.assertEquals(checkoutPage.getThankYouText(),
                "Thank you. Your order has been received.");


    }

}
