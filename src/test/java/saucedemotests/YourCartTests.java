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

import static org.junit.Assert.*;

public class YourCartTests {
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
    }
    @Test
    public void continueShopingButtonTest(){

       productsPage.clickYourCartButton();
       yourCartPage.continueShoppingButtonClick();
       assertTrue(productsPage.isProductPageDisplayed());
    }
    @Test
    public void checkoutButtonTest(){
        productsPage.clickYourCartButton();
        yourCartPage.checkoutButtonClick();
        assertTrue(checkoutYourInformationPage.isCheckoutYourInformationPageDisplayed());
    }
    @Test
    public void addOneItemToYourCartAndRemoveIt(){

        productsPage.clickAddBackpackToCartButton();
        productsPage.clickYourCartButton();
        assertEquals("1", productsPage.itemCountOnCart());
        assertEquals("Sauce Labs Backpack",yourCartPage.getBackpackTitleText());
        //assertEquals("Sauce Labs Backpack with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.",yourCartPage.getFirstItemDescriptionText());
        assertEquals("$29.99",yourCartPage.getFirstItemPriceText());
        assertEquals("Remove",yourCartPage.getBackpackRemoveButtonText());
        yourCartPage.backpackRemoveButtonClick();
        assertFalse(yourCartPage.isBackpackItemDisplayed());
        assertFalse(yourCartPage.isItemCartCountDisplayed());

    }
    @Test
    public void addTwoItemsToYourCart(){
        productsPage.clickAddTShirtToCartButton();
        productsPage.clickAddBikeToCartButton();
        productsPage.clickYourCartButton();
        assertEquals("2",yourCartPage.itemCountOnCart());
        assertEquals("Sauce Labs Bolt T-Shirt", yourCartPage.getTShirtTitleText());
        assertEquals("Get your testing superhero on with the Sauce Labs bolt T-shirt. From American Apparel, 100% ringspun combed cotton, heather gray with red bolt.",yourCartPage.getFirstItemDescriptionText());
        assertEquals("$15.99", yourCartPage.getFirstItemPriceText());
        assertEquals("Sauce Labs Bike Light", yourCartPage.getBikeTitleText());
        assertEquals("A red light isn't the desired state in testing but it sure helps when riding your bike at night. Water-resistant with 3 lighting modes, 1 AAA battery included.",yourCartPage.getSecondItemDescriptionText());
        assertEquals("$9.99", yourCartPage.getSecondItemPriceText());
        yourCartPage.bikeRemoveButtonClick();
        assertFalse(yourCartPage.isBikeItemDisplayed());
        assertEquals("1",yourCartPage.itemCountOnCart());

    }
    @Test
    public void removeCheckoutContinueButtonsTest(){
        productsPage.clickAddBikeToCartButton();
        productsPage.clickYourCartButton();
        assertEquals("#e2231a",yourCartPage.getBikeRemoveButtonColor());
        assertEquals("\"DM Sans\", sans-serif", yourCartPage.getBikeRemoveButtonFontFamily());
        assertEquals("#132322", yourCartPage.getContinueButtonColor());
        assertEquals("#132322", yourCartPage.getCheckoutButtonColor());
        assertEquals("#3ddc91", yourCartPage.getCheckoutButtonBackgroundColor());
    }


    @After
    public void tearDown(){
        driver.quit();
    }
}
