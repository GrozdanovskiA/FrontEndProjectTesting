package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class CheckoutYourInformationPageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        checkoutYourInformationPage = new CheckoutYourInformationPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage.clickYourCartButton();
        yourCartPage.checkoutButtonClick();
    }
    @Test
    public void errorMsgForFirstName(){
        checkoutYourInformationPage.continueButtonClick();
        assertEquals("Error: First Name is required", checkoutYourInformationPage.getErrorMsgText());
        checkoutYourInformationPage.xErrorMsgButtonClick();
        assertFalse(checkoutYourInformationPage.isErrorMsgDisplayed());
    }
    @Test
    public void errorMsgForLastName(){
        checkoutYourInformationPage.enterFirstName("Aleksandar");
        checkoutYourInformationPage.continueButtonClick();
        assertEquals("Error: Last Name is required", checkoutYourInformationPage.getErrorMsgText());
        checkoutYourInformationPage.xErrorMsgButtonClick();
        assertFalse(checkoutYourInformationPage.isErrorMsgDisplayed());
    }
    @Test
    public void errorMsgForPostalCode(){
        checkoutYourInformationPage.enterFirstName("ALeksandar");
        checkoutYourInformationPage.enterLastName("Grozdanovski");
        checkoutYourInformationPage.continueButtonClick();
        assertEquals("Error: Postal Code is required", checkoutYourInformationPage.getErrorMsgText());
        checkoutYourInformationPage.xErrorMsgButtonClick();
        checkoutYourInformationPage.isErrorMsgDisplayed();
    }
    @Test
    public void succesfulCheckout (){
        checkoutYourInformationPage.enterFirstName("ALeksandar");
        checkoutYourInformationPage.enterLastName("Grozdanovski");
        checkoutYourInformationPage.enterPostalCode("7000");
        checkoutYourInformationPage.continueButtonClick();
        assertEquals("Checkout: Overview", checkoutOverviewPage.isCheckoutOverviewPageDisplayed());
    }
    @Test
    public void continueButtonInterfaceTest(){
        assertEquals("16px",checkoutYourInformationPage.getContinueButtonFontSize());
        assertEquals("#3ddc91",checkoutYourInformationPage.getContinueButtonBackgroundColor());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
