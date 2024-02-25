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
     public void firstErrorMsgTest(){
        loginPage.enterUsername("asdas");
        loginPage.enterPassword("asdasd");

        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMsg());

        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMsg() );
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
    public void fifthErrorMsgTest(){
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("asda");

        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMsg());

        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMsg() );
    }



    @After
    public void tearDown() {
        driver.quit();
    }
}
