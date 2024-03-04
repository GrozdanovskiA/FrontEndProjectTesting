package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;



public class ItemReviewPage {
    private WebDriver driver;

    private By itemTitel = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[1]");
    private By itemDescription = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[2]");
    private By itemPrice = By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div[2]/div[3]");
    private By backpackRemoveButton = By.id("remove-sauce-labs-backpack");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By cartItemNumber = By.className("shopping_cart_badge");

    public ItemReviewPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickRemoveBackpackButton(){
        driver.findElement(backpackRemoveButton).click();
    }

    public String getRemoveBackpackButtonColor(){
        Color removeBackpackButtonColor = Color.fromString(driver.findElement(backpackRemoveButton).getCssValue("color"));
        return removeBackpackButtonColor.asHex();

    }
    public String getItemTitleText(){
        return driver.findElement(itemTitel).getText();
    }
    public String getItemDescriptionText(){
        return driver.findElement(itemDescription).getText();
    }
    public String getItemPrice(){
        return driver.findElement(itemPrice).getText();
    }

    public String getAddToCartBackpackColor(){
        Color addToCartBackpackButtonColor = Color.fromString(driver.findElement(addBackpackToCartButton).getCssValue("color"));
        return addToCartBackpackButtonColor.asHex();
    }
    public Boolean isItemCartCountDisplayed(){
        try{
            driver.findElement(cartItemNumber).getText();
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }
}
