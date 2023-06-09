package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator= By.id("loading");
    private By loadedText = By.id("finish");


    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStart(){
        driver.findElement(startButton).click();

//        WebDriverWait wait = new WebDriverWait(driver, 5000);
//        wait.until( driver -> driver.findElement(loadedText));

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);

            wait.until( driver -> driver.findElement(loadedText));
    }
    public String getLoadedText(){
        return driver.findElement(loadedText).getText();
    }

    public boolean isStartButtonDisplayed() {
        return driver.findElement(startButton).isDisplayed();
    }




}

