package base;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BaseTests {

   // private WebDriver driver; for event listenner we need to change this to EventFiringWebDriver, and change how we create the ChromeDriver object
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver");
        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));
         //Created EventReporter class that implements WebDriverEventListener in utils package, and registered events in the new class created
        driver.register(new EventReporter());
        driver.manage().window().maximize();
        goHome();
        setCookie();
        //deleteCookie();
        printCookie();


    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result){
        //ITestResult is a TestNG class
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
                //Files is from Com.google.common.io
            }catch (Exception e){
                e.printStackTrace();
            }
        }

    }
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }
    private ChromeOptions getChromeOptions(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars"); //old chrome version
       // options.addArguments("disable-features=AutomationControlled");//latest chrome version
        //options.setHeadless(true);

        return options;


    }
    private void setCookie(){
        Cookie cookie = new Cookie.Builder("tau","123")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().addCookie(cookie);
    }
    private void deleteCookie(){
        Cookie cookie = new Cookie.Builder("optimizelyBuckets","%7B%7D")
                .domain("the-internet.herokuapp.com")
                .build();
        driver.manage().deleteCookie(cookie);
    }
    private void printCookie(){
       var cookies = driver.manage().getCookies();
       System.out.println("Current domain cookie size: "+cookies.size());
       for(Cookie cookie : cookies){
              System.out.println("Cookie name: "+cookie.getName() + " |...Cookie value: " + cookie.getValue());
       }
    }


}
