package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;
    private By nestedFramesLink = By.linkText("Nested Frames");
   // private String leftFrame = "frame-left";
    private By leftFrame = By.xpath("//frame[@name='frame-left']");
    private By bottomFrame = By.xpath("//frame[@name='frame-bottom']");
    private By topFrame = By.xpath("//frame[@name='frame-top']");
    private By leftFrameBody = By.tagName("body");
    //private String bottomFrame = "frame-bottom";

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNestedFramesLink(){
        driver.findElement(nestedFramesLink).click();
    }
    public void switchToLeftFrame() {
        switchToTopFrame();
        driver.switchTo().frame(driver.findElement(leftFrame));

    }
    public void switchToTopFrame() {
        driver.switchTo().frame(driver.findElement(topFrame));
    }
    public void switchToBottomFrame() {
        driver.switchTo().frame(driver.findElement(bottomFrame));
    }
       public void switchToParent() {
            driver.switchTo().parentFrame();
        }
    public String getLeftFrameText(){
        switchToLeftFrame();
        String text = driver.findElement(leftFrameBody).getText();
        System.out.println(text);
        switchToParent();
        return text;
    }
    public String getBottomFrameText(){
        switchToBottomFrame();
        String text = driver.findElement(By.tagName("body")).getText();
        return text;
    }




}
