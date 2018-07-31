package autotest.test;

import autotest.base.BaseTest;
import autotest.page.MarketPage;
import autotest.page.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Collections;
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

    @Test
    public void marketTest() {
        driver.get("https://market.yandex.ru");
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
        marketPage.notItemCompared();
    }
}
