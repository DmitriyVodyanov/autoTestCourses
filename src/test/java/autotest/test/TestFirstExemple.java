package autotest.test;

import autotest.base.BaseTest;
import autotest.page.SearchPage;
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
