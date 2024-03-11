package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class CheckoutOverviewPageTest {
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

    }
    @Test
    public void checkoutOverviewCancelButtonTest(){
        assertEquals("#132322", checkoutOverviewPage.getCancelButtonColor());
        assertEquals("#132322", checkoutOverviewPage.getFinishButtonColor());
    }
    @Test
    public void itemCheckoutOverviewTest(){
        assertEquals("Sauce Labs Bike Light", checkoutOverviewPage.getBikeLightTitleText());
        assertEquals("$9.99",checkoutOverviewPage.getBikeLightPrice());
        assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.", checkoutOverviewPage.getBikeLightDescription());
    }
    @Test
    public void clichFinishButton(){
        checkoutOverviewPage.clickFinishButton();
        assertEquals("Checkout: Complete!", checkoutCompletePage.isCheckoutCompletePageDisplayed());
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
