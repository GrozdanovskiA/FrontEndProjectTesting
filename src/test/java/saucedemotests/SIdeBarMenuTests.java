package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;
import pages.SideBarMenu;

import static org.junit.Assert.assertEquals;

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
        productsPage.burgerMenuClick();
    }

    @Test
    public void aboutFuncionalityAndHoverColor() throws InterruptedException {
        Thread.sleep(500);
        sideBarMenu.hoverAboutElement();
        assertEquals("#3ddc91",sideBarMenu.getColorFromAboutTitle());
        assertEquals("https://saucelabs.com/",sideBarMenu.getHrefFromAbout());
}



    @After
    public void tearDown() {
        driver.quit();
    }
}