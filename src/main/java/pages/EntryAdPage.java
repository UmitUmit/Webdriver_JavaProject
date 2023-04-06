package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EntryAdPage {

    private WebDriver driver;
    private By closeButton = By.cssSelector("div.modal-footer p");//p[text()='Close']
    private By modalTitle = By.xpath("//div[@class='modal-title']/h3");
    private By modal = By.id("modal");


    public EntryAdPage(WebDriver driver){
        this.driver = driver;
    }

    public String getModalTitle() {
        return driver.findElement(modalTitle).getText();
    }
    public String getModalAttribute(){
        return driver.findElement(modal).getAttribute("style");
    }
    public boolean isContain(String text){
        return getModalAttribute().contains(text);
    }
    public void closeAd(){
        driver.findElement(closeButton).click();
    }







}
