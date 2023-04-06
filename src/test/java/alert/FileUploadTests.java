package alert;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload(){
        var uploadPage = homePage.clickFileUpload();
        uploadPage.uploadFile("/Users/umutbagzade/QA/Intellij-workspace/TestAutomationUniversity/Webdriver_java/resources/chromedriver");
        assertEquals(uploadPage.getUploadedFiles(), "chromedriver", "uploaded files incorrect");

    }



}
