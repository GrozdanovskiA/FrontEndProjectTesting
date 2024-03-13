package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutCompletePageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private YourCartPage yourCartPage;
    private CheckoutYourInformationPage checkoutYourInformationPage;
    private CheckoutOverviewPage checkoutOverviewPage;
    private CheckoutCompletePage checkoutCompletePage;

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
        checkoutCompletePage = new CheckoutCompletePage(driver);


        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
        productsPage.clickAddBikeToCartButton();
        productsPage.clickYourCartButton();
        yourCartPage.checkoutButtonClick();
        checkoutYourInformationPage.enterFirstName("ALeksandar");
        checkoutYourInformationPage.enterLastName("Grozdanovski");
        checkoutYourInformationPage.enterPostalCode("7000");
        checkoutYourInformationPage.continueButtonClick();
        checkoutOverviewPage.clickFinishButton();

    }
    @Test
    public void backHomeButtonTest  (){
        checkoutCompletePage.clickBackHomeButton();
        assertTrue(productsPage.isProductPageDisplayed());
    }
    @Test
    public void completedOrderMessageTest(){
        assertEquals("Thank you for your order!", checkoutCompletePage.getCompletedOrderText());
        assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!",checkoutCompletePage.getCompletedOrderDescriptionText());
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
