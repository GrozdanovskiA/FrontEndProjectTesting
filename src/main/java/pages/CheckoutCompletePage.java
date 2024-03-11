package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {
    private WebDriver driver;

    private By checkoutCompleteTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By backHomeButton = By.id("back-to-products");
    private By completedOrderMsg = By.xpath("//*[@id=\"checkout_complete_container\"]/h2");
    private By completedOrderDescription = By.xpath("//*[@id=\"checkout_complete_container\"]/div");

    public CheckoutCompletePage(WebDriver driver){
        this.driver = driver;
    }

    public String isCheckoutCompletePageDisplayed(){
        return driver.findElement(checkoutCompleteTitle).getText();
    }
    public void clickBackHomeButton (){
        driver.findElement(backHomeButton).click();
    }
    public String getCompletedOrderText(){
        return driver.findElement(completedOrderMsg).getText();
    }
    public String getCompletedOrderDescriptionText(){
        return driver.findElement(completedOrderDescription).getText();
    }
}
