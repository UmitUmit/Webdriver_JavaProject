package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WYSIWYGEditorPage {
    private WebDriver driver;
    private String editorIframeId = "mce_0_ifr";
    private By textArea = By.id("tinymce");
    private By increaseIndentButton = By.xpath("//button[@title='Increase indent']");


    public WYSIWYGEditorPage(WebDriver driver){
        this.driver = driver;
    }

    private void switchToEditArea(){
        driver.switchTo().frame(editorIframeId);
    }
    public void clearTextArea(){
        switchToEditArea();
        driver.findElement(textArea).clear();
        switchToMainArea();
    }
    public String getTextFromEditor(){
        switchToEditArea();
        String text = driver.findElement(textArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

    public void setTextArea(String text){
        switchToEditArea();
        driver.findElement(textArea).sendKeys(text);
        switchToMainArea();
    }
    public void increaseIndent(){
        driver.findElement(increaseIndentButton).click();
    }


}
