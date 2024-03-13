package saucedemotests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.ProductsPage;

import static org.junit.Assert.assertEquals;

public class LoginPageParameterizedTests {
    private WebDriver driver;
    private LoginPage loginPage;


    @ParameterizedTest
    @ValueSource(strings = {"asds", "standard_user"})
    public void errorMsgParameterizedTest(String username){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");


        loginPage = new LoginPage(driver);

        loginPage.enterUsername(username);
        loginPage.enterPassword("asdasd");

        loginPage.clickLoginButton();
        System.out.println(loginPage.getErrorMsg());

        assertEquals("Epic sadface: Username and password do not match any user in this service",loginPage.getErrorMsg() );
        driver.quit();
    }
}
