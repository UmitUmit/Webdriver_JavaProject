package navigation;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {

    @Test
    public void testNavigator(){
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://google.com/");
    }

    @Test
    public void testSwitchTab(){
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab(("New Window"));
    }

    @Test
    public void testSwitchTab2(){

       var examplePage =  homePage.clickDynamicLoading();
       var example2Page = examplePage.openExample2InNewTab();
       getWindowManager().switchToSecondTab();
       assertTrue(example2Page.isStartButtonDisplayed(), "Start button is not displayed");

    }




}
