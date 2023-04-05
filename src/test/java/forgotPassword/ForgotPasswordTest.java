package forgotPassword;

import base.BaseTests;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseTests {

    @Test
    public void testRetrievePassword(){
        var forgotPasswordPage = homePage.clickForgotPassword();
        forgotPasswordPage.enterEmail("tau@example.com");
        forgotPasswordPage.clickRetrevePasswordButton();
        System.out.println(forgotPasswordPage.getAlertText());
//        assertTrue(forgotPasswordPage.getAlertText().contains("Your e-mail's been sent!"));

    }




}
