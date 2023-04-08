package javascript;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class JSDropdownTest extends BaseTests {

    @Test
    public void testJSDropdown(){
        var jsDropdownPage = homePage.clickJSDropdown();
        jsDropdownPage.setAttributeMultiple();
        jsDropdownPage.selectFromDropdown("Option 1");
        assertEquals(jsDropdownPage.getAttributeValueOption1(), "true", "Option 1 is not selected");

        jsDropdownPage.selectFromDropdown("Option 2");
        assertEquals(jsDropdownPage.getAttributeValueOption2(), "true", "Option 2 is not selected");
    }



}
