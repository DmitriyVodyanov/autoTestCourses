package autotest.test;

import autotest.base.BaseTest;
import autotest.page.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.assertTrue;

public class TestExemple extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    public void beforeTest() {
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Test
    public void SearchWeather() {
        searchPage.searchWeather("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @Test
    public void compareListMoreTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocation("лондон");
        List<String> moreListcityOne = searchPage.getMoreCatalog();
        searchPage.selectLocation("париж ");
        List<String> moreListcityTwo = searchPage.getMoreCatalog();
        Collections.sort(moreListcityOne);
        Collections.sort(moreListcityTwo);
        Assert.assertTrue(moreListcityOne.equals(moreListcityTwo));
    }
}
