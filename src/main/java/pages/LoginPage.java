package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;


public class LoginPage {
    private WebDriver driver;

    //Locators
    private By usernameField = By.id("user-name");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login-button");
    private By errorMsg = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3");
    private By errorMsgContainer = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]");
    private By xErrorMsgButton = By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3/button");


    public LoginPage(WebDriver driver) {
        this.driver = driver;

    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMsg() {
        return driver.findElement(errorMsg).getText();

    }

    public void clickErrorMsgButton() {
        driver.findElement(xErrorMsgButton).click();
    }
    public Boolean isErrorMsgDisplayed(){
        try{
            driver.findElement(errorMsg).getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public String getUsernameFieldFontType(){
        return driver.findElement(usernameField).getCssValue("font-family");
    }
    public String getUsernameFieldFontSize(){
        return driver.findElement(usernameField).getCssValue("font-size");
    }
    public String getPasswordFieldFontType(){
        return driver.findElement(passwordField).getCssValue("font-family");
    }
    public String getPasswordFieldFontSize(){
        return driver.findElement(passwordField).getCssValue("font-size");
    }
    public String getLoginButtonBackgroundColor(){
        Color loginButtonBackgroundColour = Color.fromString(driver.findElement(loginButton).getCssValue("background-color"));
        return loginButtonBackgroundColour.asHex();
    }
    public String getLoginButtonFontSize(){
        return driver.findElement(loginButton).getCssValue("font-size");
    }
    public String getLoginButtonFontType(){
        return driver.findElement(loginButton).getCssValue("font-family");
    }
    public String getErrorMsgContainerColor(){
        Color errorMsgBackgroundColour = Color.fromString(driver.findElement(errorMsgContainer).getCssValue("background-color"));
        return errorMsgBackgroundColour.asHex();
    }
    public String getUsernameFieldBorderBottomColor(){
        Color usernameFieldBorderBottomColour = Color.fromString(driver.findElement(usernameField).getCssValue("border-bottom-color"));
        return usernameFieldBorderBottomColour.asHex();
    }
    public String getPasswordFieldBorderBottomColor(){
        Color passwordFieldBorderBottomColour = Color.fromString(driver.findElement(passwordField).getCssValue("border-bottom-color"));
        return passwordFieldBorderBottomColour.asHex();
    }

}


