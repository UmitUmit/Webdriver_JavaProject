package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jsDropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");
    private By option1 = By.xpath("//option[@value='1']");
    private By option2 = By.xpath("//option[@value='2']");

    public jsDropdownPage(WebDriver driver){
        this.driver = driver;
    }

    public void setAttributeMultiple(){
        String script = "arguments[0].setAttribute('multiple', '')";
        var jsExecutor = (JavascriptExecutor)driver;
        WebElement element = driver.findElement(dropdown);
        jsExecutor.executeScript(script, element);
    }
    public void selectOption1(){
        driver.findElement(option1).click();
    }
    public void selectOption2(){
        driver.findElement(option2).click();
    }
    public String getAttributeValueOption1(){

        return driver.findElement(option1).getAttribute("selected");
    }
    public String getAttributeValueOption2(){

        return driver.findElement(option2).getAttribute("selected");
    }
    public void selectFromDropdown(String option){
        By locator = null;
        if (option.equals("Option 1"))
            locator = option1;
        else if (option.equals("Option 2"))
            locator = option2;
        else
            System.out.println("Option not found");

        findDropdownElement().selectByVisibleText(option);
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.attributeToBe(locator, "selected", "true"));
    }

    private Select findDropdownElement() {
        return new Select(driver.findElement(dropdown));
    }


}
