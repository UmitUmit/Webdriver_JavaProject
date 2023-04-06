package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFrameTest extends BaseTests {

    @Test
    public void testNestedFrame(){
        var framesPage = homePage.clickFrames();
        framesPage.clickNestedFramesLink();
        framesPage.switchToLeftFrame();
        assertEquals(framesPage.getLeftFrameText(),"LEFT", "Left frame text incorrect");
        framesPage.switchToBottomFrame();
        assertEquals(framesPage.getBottomFrameText(),"BOTTOM", "Botton frame text incorrect");
    }



}
