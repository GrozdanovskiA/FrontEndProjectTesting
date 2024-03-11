package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class YourCartPage {
    private WebDriver driver;

    private By continueShoppingButton = By.id("continue-shopping");
    private By checkoutButton = By.id("checkout");
    private By backpackTitle = By.id("item_4_title_link");
    private By tShirtTitle = By.id("item_1_title_link");
    private By bikeTitle = By.id("item_0_title_link");
    private By firstItemDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]");
    private By secondItemDescription = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]");
    private By firstItemPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div");
    private By secondItemPrice = By.xpath("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div");
    private By backpackRemoveButton = By.id("remove-sauce-labs-backpack");
    private By bikeRemoveButton = By.id("remove-sauce-labs-bike-light");
    private By cartItemNumber = By.className("shopping_cart_badge");



    public YourCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void  continueShoppingButtonClick(){
        driver.findElement(continueShoppingButton).click();
    }
    public void  checkoutButtonClick(){
        driver.findElement(checkoutButton).click();
    }
    public String getBackpackTitleText(){
        return driver.findElement(backpackTitle).getText();
    }
    public String getTShirtTitleText(){
        return driver.findElement(tShirtTitle).getText();
    }
    public String getBikeTitleText(){
        return driver.findElement(bikeTitle).getText();
    }
    public String getFirstItemDescriptionText(){
        return driver.findElement(firstItemDescription).getText();
    }
    public String getSecondItemDescriptionText(){
        return driver.findElement(secondItemDescription).getText();
    }

    public String getFirstItemPriceText(){
        return driver.findElement(firstItemPrice).getText();
    }
    public String getSecondItemPriceText(){
        return driver.findElement(secondItemPrice).getText();
    }
    public void backpackRemoveButtonClick(){
        driver.findElement(backpackRemoveButton).click();
    }
    public void bikeRemoveButtonClick(){
        driver.findElement(bikeRemoveButton).click();
    }

    public String getBackpackRemoveButtonText(){
        return driver.findElement(backpackRemoveButton).getText();
    }
    public Boolean isBackpackItemDisplayed(){
        try{
            driver.findElement(backpackTitle).getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public Boolean isBikeItemDisplayed(){
        try{
            driver.findElement(bikeTitle).getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public Boolean isItemCartCountDisplayed(){
        try{
            driver.findElement(cartItemNumber).getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
    public String itemCountOnCart(){
        return driver.findElement(cartItemNumber).getText();
    }

    public String getBikeRemoveButtonColor(){
        Color BikeRemoveButtonColour = Color.fromString(driver.findElement(bikeRemoveButton).getCssValue("color"));
        return BikeRemoveButtonColour.asHex();
    }
    public String getBikeRemoveButtonFontFamily(){
        return driver.findElement(bikeRemoveButton).getCssValue("font-family");
    }
    public String getContinueButtonColor(){
        Color ContinueButtonColour = Color.fromString(driver.findElement(continueShoppingButton).getCssValue("color"));
        return ContinueButtonColour.asHex();
    }
    public String getCheckoutButtonColor(){
        Color CheckoutButtonColour = Color.fromString(driver.findElement(checkoutButton).getCssValue("color"));
        return CheckoutButtonColour.asHex();
    }
    public String getCheckoutButtonBackgroundColor(){
        Color CheckoutButtonBackgroundColour = Color.fromString(driver.findElement(checkoutButton).getCssValue("background-color"));
        return CheckoutButtonBackgroundColour.asHex();
    }



}
