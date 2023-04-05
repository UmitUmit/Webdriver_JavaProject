package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class ForgotPasswordPage {

    private WebDriver driver;


    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }


    public void enterEmail(String email) {
        driver.findElement(By.cssSelector("#email")).sendKeys(email);
    }

    public void clickRetrevePasswordButton() {
        driver.findElement(By.cssSelector("#form_submit")).click();
    }

    public String getAlertText() {

        return driver.getPageSource();
    }
}
