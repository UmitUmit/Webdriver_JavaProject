package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ShiftingContentPage {

    private WebDriver driver;
    private By header = By.cssSelector("#content h3");

    //Shifting Content

    public ShiftingContentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getHeaderText(){
        return driver.findElement(header).getText();
    }

    public void clickExample1() {
        driver.findElement(By.linkText("Example 1: Menu Element")).click();
    }

    public List<String> getMenuItems() {

        List<WebElement> menuElements = driver.findElements(By.cssSelector("#content ul li a"));
        return menuElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void printMenuItems() {
        List<String> menuItems = getMenuItems();
        for(String menuItem : menuItems){
            System.out.println(menuItem);
        }
    }
}
