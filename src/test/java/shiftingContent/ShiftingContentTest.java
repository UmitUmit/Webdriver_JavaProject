package shiftingContent;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ShiftingContentTest extends BaseTests {

    @Test
    public void testShiftingContent(){
        var shiftingContentPage = homePage.clickShiftingContent();
        shiftingContentPage.clickExample1();
        assertEquals(shiftingContentPage.getMenuItems().size(), 5, "Incorrect number of menu items");
        shiftingContentPage.printMenuItems();

    }
}
