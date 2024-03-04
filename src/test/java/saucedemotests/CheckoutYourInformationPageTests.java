package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.CheckoutYourInformationPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckoutYourInformationPageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage.clickYourCartButton();
        yourCartPage.checkoutButtonClick();
    }
    @Test
    public void errorMsgForFirstname(){
        checkoutYourInformationPage.continueButtonClick();
        assertEquals("Error: First Name is required", checkoutYourInformationPage.getErrorMsgText());
        checkoutYourInformationPage.xErrorMsgButtonClick();
        assertFalse(checkoutYourInformationPage.isErrorMsgDisplayed());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
