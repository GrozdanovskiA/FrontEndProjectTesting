package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ItemReviewPage;
import pages.LoginPage;
import pages.ProductsPage;
import pages.YourCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ItemReviewPageTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private ItemReviewPage itemReviewPage;



    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        itemReviewPage = new ItemReviewPage(driver);


        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
    }
    @Test
    public void checkBackpackItemSeparatelyTest(){
        productsPage.clickAddBackpackToCartButton();
        productsPage.clickOnBackpackTitle();
        itemReviewPage.getItemTitleText();

        assertEquals("#e2231a", itemReviewPage.getRemoveBackpackButtonColor());
        assertEquals("Sauce Labs Backpack", itemReviewPage.getItemTitleText());
        assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.", itemReviewPage.getItemDescriptionText());
        assertEquals("$29.99", itemReviewPage.getItemPrice());
        itemReviewPage.clickRemoveBackpackButton();
        assertEquals("#132322",itemReviewPage.getAddToCartBackpackColor());
        assertFalse(itemReviewPage.isItemCartCountDisplayed());

    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
