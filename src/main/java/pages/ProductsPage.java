package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.util.List;

public class ProductsPage {
    private WebDriver driver;
    Actions actions;

    private By burgerMenu = By.id("react-burger-menu-btn");
    private By productsTitle = By.className("title");
    private By backpackTitle = By.xpath("//*[@id=\"item_4_title_link\"]/div");
    private By addBackpackToCartButton = By.id("add-to-cart-sauce-labs-backpack");
    private By clickBackpackHref = By.id("item_4_title_link");
    private By clickBikeLightHref = By.id("item_0_title_link");
    private By addTShirtToCartButton = By.id("add-to-cart-sauce-labs-bolt-t-shirt");
    private By addBikeToCartButton = By.id("add-to-cart-sauce-labs-bike-light");
    private By removeBackpackFromCartButton = By.id("remove-sauce-labs-backpack");
    private By mostExpensivePriceText = By.xpath("//*[@id=\"inventory_container\"]/div/div[1]/div[2]/div[2]/div");
    private By yourCartIcon = By.id("shopping_cart_container");
    private By cartItemNumber = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    public void burgerMenuClick(){
        driver.findElement(burgerMenu).click();
    }
    public boolean isProductPageDisplayed() {
        return driver.findElement(productsTitle).getText().equals("Products");
    }
    public void clickAddTShirtToCartButton() {
        driver.findElement(addTShirtToCartButton).click();
    }
    public void clickAddBikeToCartButton() {
        driver.findElement(addBikeToCartButton).click();
    }
    public void clickAddBackpackToCartButton() {
        driver.findElement(addBackpackToCartButton).click();
    }
    public void clickOnBackpackTitle(){
        driver.findElement(clickBackpackHref).click();
    }
    public void clickOnBikeLightTitle(){
        driver.findElement(clickBikeLightHref).click();
    }

    public String removeBackpackButton() {
        return driver.findElement(removeBackpackFromCartButton).getText();
    }

    public List<WebElement> getAllOptionsFromOrderingDropDown() {
        Select orderingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return orderingDropDown.getOptions();
    }

    public void selectOrderingDropDownOption(int optionNumber) {
        Select orderingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        orderingDropDown.selectByIndex(optionNumber);
    }

    public String getMostExpensivePriceText() {
        return driver.findElement(mostExpensivePriceText).getText();
    }

    public String getOrderingDropdownText() {
        Select orderingDropDown = new Select(driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div/span/select")));
        return orderingDropDown.getFirstSelectedOption().getText();
    }

    public void clickYourCartButton() {
        driver.findElement(yourCartIcon).click();
    }
    public String itemCountOnCart() {
        return driver.findElement(cartItemNumber).getText();
    }

    public void hoverElement(){
        WebElement backpackTitleElement = driver.findElement(clickBackpackHref);
        actions.moveToElement(backpackTitleElement).perform();
    }
    public String getColorFromBackpackTitle(){
        Color CheckoutButtonBackgroundColour = Color.fromString(driver.findElement(backpackTitle).getCssValue("color"));
        return CheckoutButtonBackgroundColour.asHex();
    }

}
