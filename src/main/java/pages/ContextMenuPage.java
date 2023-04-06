package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {

    private WebDriver driver;
    private By contextMenu = By.id("hot-spot");
    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
    }

    public void rightClickOnBox(){
        Actions actions = new Actions(driver);
        WebElement element = driver.findElement(contextMenu);
        actions.contextClick(element).perform();
    }


    public String getAlertText() {

        return driver.switchTo().alert().getText();
    }
    public void printAlertText(){
        System.out.println(getAlertText());
    }
    public void acceptAlert(){
        driver.switchTo().alert().accept();
    }
    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

}
