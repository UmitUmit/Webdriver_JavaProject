package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class FileUploadPage {

    private WebDriver driver;
//    private WebDriverWait wait;
    private By inputField = By.id("file-upload");
    private By uploadButton = By.id("file-submit");
    private By uploadedFiles = By.id("uploaded-files");

    public FileUploadPage(WebDriver driver){
        this.driver = driver;
    }


    public void clickUploadButton(){
        driver.findElement(uploadButton).click();
    }

    /**
     * Provides path to file to the form then clicks Upload button
     * @param absolutePathOfFile The complete path to the file to be uploaded
     */
    public void uploadFile(String absolutePathOfFile){
        driver.findElement(inputField).sendKeys(absolutePathOfFile);
        clickUploadButton();
    }
    public String getUploadedFiles(){
        return driver.findElement(uploadedFiles).getText();
    }


//    public static WebDriver waitUntilUploadButtonElementVisible(){
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(uploadButton));
//        return driver;
//    }




//    public void wait_UploadButtonPresent( ){
////        Wait <WebDriver> wait = new FluentWait<>(driver)
////                .withTimeout(Duration.ofSeconds(60))
////                .pollingEvery(Duration.ofSeconds(5))
////                .ignoring(NoSuchElementException.class);
//
//
//        WebDriverWait wait = new WebDriverWait(driver, 45);
//
//        wait.until(ExpectedConditions(uploadButton));
//        System.out.println("Button is clickable now");
//
//    }

}
