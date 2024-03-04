package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutYourInformationPage {

    private WebDriver driver;
    private By checkoutYourInformationPageTitle = By.className("title");
    private By continueButton = By.id("continue");
    private By errorMsg = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3");
    private By xErrorMsgButton = By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[1]/div[4]/h3/button");

    public CheckoutYourInformationPage(WebDriver driver){
        this.driver = driver;
    }
    public boolean isCheckoutYourInformationPageDisplayed(){
        return driver.findElement(checkoutYourInformationPageTitle ).getText().equals("Checkout: Your Information");
    }
    public void continueButtonClick(){
        driver.findElement(continueButton).click();
    }
    public String getErrorMsgText(){
        return driver.findElement(errorMsg).getText();
    }
    public void xErrorMsgButtonClick(){
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
}
