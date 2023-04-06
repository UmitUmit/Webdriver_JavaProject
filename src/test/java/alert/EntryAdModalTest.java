package alert;

import base.BaseTests;
import org.testng.annotations.Test;


import static org.testng.Assert.*;

public class EntryAdModalTest extends BaseTests {

    @Test
    public void testCloseModal(){
        var entryAdPage = homePage.clickEntryAd();
        assertEquals(entryAdPage.getModalTitle(), "This is a modal window", "modal title is incorrect");
        entryAdPage.closeAd();
        entryAdPage.isContain("display: none");







    }





}
