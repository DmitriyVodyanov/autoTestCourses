package autotest.lecture05.tests;

import autotest.lecture05.base.BaseTest;
import autotest.lecture05.pages.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class TestFirstExemple extends BaseTest {

    private static SearchPage searchPage;

    @BeforeClass
    public void beforeTest() {
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test
    public void SearchWeather() {
        searchPage.search("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }
}
