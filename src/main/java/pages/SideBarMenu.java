package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class SideBarMenu {
    private WebDriver driver;
    Actions actions;
    private By allItemsText = By.id("inventory_sidebar_link");
    private By aboutText = By.id("about_sidebar_link");
    private By logoutText = By.id("logout_sidebar_link");
    private By resetAppStateText = By.id("reset_sidebar_link");

    public SideBarMenu(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }
    public String getAllItemsText(){
        return driver.findElement(allItemsText).getText();
    }
    public String getAboutText(){
        return driver.findElement(aboutText).getText();
    }
    public String getLogoutText(){
        return driver.findElement(logoutText).getText();
    }
    public String getResetAppText(){
        return driver.findElement(resetAppStateText).getText();
    }
    public void hoverAboutElement(){
        WebElement backpackTitleElement = driver.findElement(aboutText);
        actions.moveToElement(backpackTitleElement).perform();
    }
    public String getColorFromAboutTitle(){
        Color CheckoutButtonBackgroundColour = Color.fromString(driver.findElement(aboutText).getCssValue("color"));
        return CheckoutButtonBackgroundColour.asHex();
    }
//    public void clickAboutTItle(){
//        driver.findElement(aboutText).click();
//    }
    public String getHrefFromAbout(){
        WebElement aboutTextElement = driver.findElement(aboutText);
        return aboutTextElement.getAttribute("href");
    }
}
