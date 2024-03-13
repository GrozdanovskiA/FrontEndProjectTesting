package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SideBarMenu;

public class SIdeBarMenuTests {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;
    private SideBarMenu sideBarMenu;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        sideBarMenu = new SideBarMenu(driver);

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        loginPage.clickLoginButton();
    }

//    @Test
//    public void hoverOnAllItems(){
//        productsPage.burgerMenuClick();
//        sideBarMenu.hoverOnAllItems();
//    }



    @After
    public void tearDown() {
        driver.quit();
    }
}