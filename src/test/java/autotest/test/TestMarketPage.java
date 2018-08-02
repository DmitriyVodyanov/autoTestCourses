package autotest.test;

import autotest.base.BaseTest;
import autotest.page.MarketPage;
import autotest.page.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestMarketPage extends BaseTest {

    private SearchPage searchPage;
    private MarketPage marketPage;

    @BeforeClass
    public void beforeTest() {
        driver.get("https://market.yandex.ru");
        searchPage = PageFactory.initElements(driver, SearchPage.class);
        marketPage = PageFactory.initElements(driver, MarketPage.class);
    }

    @Test
    public void compareItemTest() {
        marketPage.selectCompLaptop();
        marketPage.addCompareElement();
        assertTrue(marketPage.getComparedItemOnPage() > 0);
        marketPage.removeElementsCopared();
        assertEquals(marketPage.notItemCompared().toLowerCase(), "товаров нет");
    }

    @Test
    public void marketQuantityItemOnPageTest() {
        marketPage.selectCompLaptop();
        assertEquals(marketPage.getCatalogComputers(), 48);
        marketPage.selectTwelveElementsPage();
        assertEquals(marketPage.getCatalogComputers(), 12);
    }

    @Test
    public void sortByPriseTest() {
        marketPage.selectCompLaptop();
        marketPage.sortByPriceClick();
        assertTrue(marketPage.sortPriceLinkSelected().contains("n-filter-sorter_sort_asc"), "сортировка по возрастанию");
        marketPage.sortByPrice();
        assertTrue(marketPage.sortList());
    }
}

