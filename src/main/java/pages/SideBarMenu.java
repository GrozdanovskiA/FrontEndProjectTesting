package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SideBarMenu {
    private WebDriver driver;
    Actions action;


   // private By allItems = By.id("inventory_sidebar_link");
  //  WebElement allItems = driver.findElement(By.id("inventory_sidebar_link"));

    public SideBarMenu(WebDriver driver) {
        this.driver = driver;
        this.action = new Actions(driver);
    }

//    public  void hoverOnAllItems(){
//        action.moveToElement(allItems).perform();
//    }



}
