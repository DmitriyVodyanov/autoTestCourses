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

public class TestExemple extends BaseTest {

    private SearchPage searchPage;
    private MarketPage marketPage;

    @BeforeClass
    public void beforeTest() {
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        marketPage = PageFactory.initElements(driver, MarketPage.class);
    }

    @Ignore
    @Test
    public void SearchWeather() {
        driver.get("https://www.yandex.ru/");
        searchPage.searchWeather("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @Ignore
    @Test
    public void compareListMoreTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocation("лондон");
        List<String> moreListCityOne = searchPage.getMoreCatalog();
        moreListCityOne.set(5, "asdfasd");
        System.out.println(moreListCityOne);
        searchPage.selectLocation("париж ");
        List<String> moreListCityTwo = searchPage.getMoreCatalog();
        System.out.println(moreListCityTwo);
        if (moreListCityOne.size() != moreListCityTwo.size()) {
            System.out.println("Списки не равны по длине");
        }
        if (moreListCityOne.size() == moreListCityTwo.size()) {
            for (int i = 0; i < moreListCityOne.size(); i++) {
                Assert.assertEquals(moreListCityOne.get(i), moreListCityTwo.get(i));
            }
        }
    }

    @Ignore
    @Test
    public void marketTest() {
        driver.get("https://market.yandex.ru");
        marketPage.selectCompLaptop();
        marketPage.getCatalogComputers();
        assertEquals(marketPage.getCatalogComputers(), 48);
        marketPage.computerTwelveElementsPage();
        marketPage.getCatalogComputers();
        assertEquals(marketPage.getCatalogComputers(), 12);
    }


    @Ignore
    @Test
    public void compareItem() {
        driver.get("https://market.yandex.ru");
        marketPage.selectCompLaptop();
        marketPage.compareElementPage();
        assertTrue(marketPage.getComparedItemOnPage() > 0);
        marketPage.removeElementsCopared();
//        assertTrue(marketPage.notItemCompared().toLowerCase().contains("товаров нет"));
        assertEquals(marketPage.notItemCompared().toLowerCase(), "товаров нет");
    }

    @Test
    public void sortByPriseTest() {

        System.out.println(marketPage.sortByPrice());
    }

    @Ignore
    @Test
    public void navigationPage() {
        driver.get("https://yandex.ru");
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


        /*driver.get("https://market.yandex.ru");
        marketPage.computerTwelveElementsPage();
        List<Integer> laptopCatalog = Collections.singletonList(marketPage.getCatalogComputers());
        System.out.println(marketPage.getCatalogComputers());
        assertEquals(marketPage.getCatalogComputers(), 12);
        marketPage.computerFortyEightElementsPage();
        assertEquals(marketPage.getCatalogComputers(), 48);

        marketPage.compareElementPage();
        assertTrue(marketPage.getComparedItemOnPage() > 0);
        marketPage.removeElementsCopared();
        assertTrue(marketPage.notItemCompared().toLowerCase().contains("товаров нет"));
        marketPage.notItemCompared();*/
}

