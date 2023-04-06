package menu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ContextMenuTest extends BaseTests {

    @Test
    public void testContextMenu(){
       var contextMenuPage = homePage.clickContextMenu();
       contextMenuPage.rightClickOnBox();
       contextMenuPage.printAlertText();
       assertEquals(contextMenuPage.getAlertText(),"You selected a context menu", "Alert text incorrect");
         contextMenuPage.acceptAlert();
    }


}
