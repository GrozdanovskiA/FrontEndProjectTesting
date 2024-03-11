package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class CheckoutOverviewPage {
    private WebDriver driver;
    private By checkoutOverviewTitle = By.xpath("//*[@id=\"header_container\"]/div[2]/span");
    private By cancelButton = By.id("cancel");
    private By finishButton = By.id("finish");
    private By itemTitle = By.xpath("//*[@id=\"item_0_title_link\"]/div");
    private By itemPrice = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By itemDescription = By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[1]");

    public CheckoutOverviewPage(WebDriver driver){
        this.driver = driver;
    }

    public String isCheckoutOverviewPageDisplayed (){
        return driver.findElement(checkoutOverviewTitle).getText();
    }
    public String getCancelButtonColor(){
        Color cancelBottomColour = Color.fromString(driver.findElement(cancelButton).getCssValue("color"));
        return cancelBottomColour.asHex();
    }
    public String getFinishButtonColor(){
        Color finishButtonColour = Color.fromString(driver.findElement(finishButton).getCssValue("color"));
        return finishButtonColour.asHex();
    }
    public String getBikeLightTitleText(){
        return driver.findElement(itemTitle).getText();
    }
    public String getBikeLightPrice(){
        return driver.findElement(itemPrice).getText();
    }
    public String getBikeLightDescription (){
        return driver.findElement(itemDescription).getText();
    }
    public void clickFinishButton(){
        driver.findElement(finishButton).click();
    }
}
