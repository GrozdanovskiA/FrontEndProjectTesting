package saucedemotests;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertEquals;

public class ProductsPageTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);

        productsPage = new ProductsPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
    }

    @Test
    public void addToCartButtonTest(){
        productsPage.clickAddBackpackToCartButton();

        assertEquals("Remove", productsPage.removeBackpackButton());
    }
    @Test
    public void orderingDropDownTest(){
        assertEquals("Name (A to Z)", productsPage.getAllOptionsFromOrderingDropDown().get(0).getText());
        assertEquals("Name (Z to A)", productsPage.getAllOptionsFromOrderingDropDown().get(1).getText());
        assertEquals("Price (low to high)", productsPage.getAllOptionsFromOrderingDropDown().get(2).getText());
        assertEquals("Price (high to low)", productsPage.getAllOptionsFromOrderingDropDown().get(3).getText());
    }
    @Test
    public void orderingFromHighToLowPriceTest(){
        productsPage.selectOrderingDropDownOption(3);
        assertEquals("Price (high to low)",productsPage.getOrderingDropdownText());
        assertEquals("$49.99", productsPage.getMostExpensivePriceText());
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
