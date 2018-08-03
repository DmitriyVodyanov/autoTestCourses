package autotest.test;

import autotest.base.BaseTest;
import autotest.page.MarketPage;
import autotest.page.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestSeachPage extends BaseTest {

    private SearchPage searchPage;
    private MarketPage marketPage;

    @BeforeClass
    public void beforeTest() {
        driver.get("https://www.yandex.ru/");
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        marketPage = PageFactory.initElements(driver, MarketPage.class);
    }

    @Ignore
    @Test
    public void SearchWeatherTest() {
        searchPage.searchWeather("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @Test
    public void compareListMoreTest() {
        searchPage.selectLocation("лондон");
        List<String> moreListCityOne = searchPage.getMoreCatalog();
        searchPage.selectLocation("париж ");
        List<String> moreListCityTwo = searchPage.getMoreCatalog();
        if (moreListCityOne.size() == moreListCityTwo.size()) {
            for (int i = 0; i < moreListCityOne.size(); i++) {
                Assert.assertEquals(moreListCityOne.get(i), moreListCityTwo.get(i));
            }
        } else
            System.out.println("Списки не равны по длине");
    }

    @Test
    public void navigationPageTest() {
        searchPage.navigationVideo();
        assertEquals(searchPage.getByUrl(), "https://yandex.ru/video/");
        searchPage.navigationImages();
        assertEquals(searchPage.getByUrl(), "https://yandex.ru/images/");
        searchPage.navigationNews();
        assertEquals(searchPage.getByUrl(), "https://news.yandex.ru/");
        searchPage.navigationMaps();
        assertTrue(searchPage.getByUrl().contains("https://yandex.ru/maps/"));
        searchPage.navigationMarket();
        assertTrue(searchPage.getByUrl().contains("https://market.yandex.ru/"));
        searchPage.navigationTranslate();
        assertEquals(searchPage.getByUrl(), "https://translate.yandex.ru/");
        searchPage.navigationMusic();
        assertTrue(searchPage.getByUrl().contains("https://music.yandex.ru/"));
        searchPage.navigationTvOnline();
        assertEquals(searchPage.getByUrl(), "https://yandex.ru/1tv?stream_active=storefront/");
    }
}







