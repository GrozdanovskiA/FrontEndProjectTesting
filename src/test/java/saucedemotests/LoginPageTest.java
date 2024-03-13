package saucedemotests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.*;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private ProductsPage productsPage;


    @Before
    public void setUp(){
    //initialize ChromedDriver instance
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.saucedemo.com/");


    loginPage = new LoginPage(driver);

   // driver.get("https://www.saucedemo.com/inventory.html");
    productsPage = new ProductsPage(driver);


    }
    @Test
    public void succesfulLoginTest(){
        //enter username and password
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        //click on the login button
        loginPage.clickLoginButton();


        //verify login seccesful
        assertTrue(productsPage.isProductPageDisplayed());

    }

    @Test
    public void secondErrorMsgTest(){
        loginPage.enterUsername("aasggs");

        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMsg());

        assertEquals("Epic sadface: Password is required",loginPage.getErrorMsg() );
    }
    @Test
    public void thirdErrorMsgTest(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("");

        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMsg());

        assertEquals("Epic sadface: Password is required",loginPage.getErrorMsg() );
    }
    @Test
    public void fourthErrorMsgTest(){
        loginPage.enterUsername("");


        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMsg());

        assertEquals("Epic sadface: Username is required",loginPage.getErrorMsg() );
    }

    @Test
    public void errorMsgXButtonTest(){
        loginPage.clickLoginButton();
        loginPage.clickErrorMsgButton();

        assertFalse(loginPage.isErrorMsgDisplayed());
    }
    @Test
    public void loginFormInitialStateUserInterfaceTest(){
        assertEquals("#3ddc91", loginPage.getLoginButtonBackgroundColor());
        assertEquals("16px", loginPage.getLoginButtonFontSize());
        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getLoginButtonFontType());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getUsernameFieldFontType());
        assertEquals("14px", loginPage.getUsernameFieldFontSize());

        assertEquals("\"DM Sans\", Arial, Helvetica, sans-serif", loginPage.getPasswordFieldFontType());
        assertEquals("14px", loginPage.getPasswordFieldFontSize());
    }
    @Test
    public void loginFormErrorStateUserInterfaceTest(){
        loginPage.clickLoginButton();
        assertEquals("#e2231a", loginPage.getUsernameFieldBorderBottomColor());
        assertEquals("#e2231a", loginPage.getPasswordFieldBorderBottomColor());
        assertEquals("#e2231a",loginPage.getErrorMsgContainerColor());
    }


    @After
    public void tearDown() {
        driver.quit();
    }
}
