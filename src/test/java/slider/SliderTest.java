package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTest extends BaseTests {

    @Test
    public void testSlider(){
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setSliderValue("4");
        assertEquals(sliderPage.getSliderValue(), "4", "Slider value incorrect");
    }



}
