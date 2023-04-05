package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HorizontalSliderPage {

    private WebDriver driver;
    private By slider = By.tagName("input");
   // private By range = By.tagName("span");

    public HorizontalSliderPage(WebDriver driver){
        this.driver = driver;
    }

    public void setSliderValue(String value){
        while(!getSliderValue().equals(value)){
            driver.findElement(slider).sendKeys(Keys.ARROW_RIGHT);
        }
    }

    public String getSliderValue() {
        WebElement sliderElement = driver.findElement(slider);
        System.out.println(sliderElement.getAttribute("value"));
        return sliderElement.getAttribute("value");
    }


}
