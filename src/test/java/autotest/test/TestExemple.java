package autotest.test;

import autotest.base.BaseTest;
import autotest.page.MarketPage;
import autotest.page.SearchPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestExemple extends BaseTest {

    private SearchPage searchPage;

    @BeforeClass
    public void beforeTest() {
        searchPage = PageFactory.initElements(driver, SearchPage.class);
    }

    @Ignore
    @Test
    public void SearchWeather() {
        driver.get("https://www.yandex.ru/");
        searchPage.searchWeather("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @Test
    public void compareListMoreTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocation("лондон");
        List<String> moreListCityOne = searchPage.getMoreCatalog();
        moreListCityOne.add("Почта");
        System.out.println(moreListCityOne);
        searchPage.selectLocation("париж ");
        List<String> moreListCityTwo = searchPage.getMoreCatalog();
        System.out.println(moreListCityTwo);
        for (String elementOne : moreListCityOne) {
            for (String elementTwo : moreListCityTwo) {
                assertEquals(elementOne, elementTwo);
            }
        }
    }
}
