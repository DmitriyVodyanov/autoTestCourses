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
    private MarketPage marketPage;

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

    //    @Ignore
    @Test
    public void compareListMoreTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocation("лондон");
        List<String> moreListCityOne = searchPage.getMoreCatalog();
        moreListCityOne.add("ролфырвлоРФЫЛВРвф6487498ы");
        
        System.out.println(moreListCityOne);
        searchPage.selectLocation("париж ");
        List<String> moreListCityTwo = searchPage.getMoreCatalog();
//        moreListCityTwo.add("asdasdasda1");
//        moreListCityTwo.remove(4);
        System.out.println(moreListCityTwo);
        Collections.sort(moreListCityOne);
        Collections.sort(moreListCityTwo);
//        Assert.assertTrue(moreListCityOne.equals(moreListCityTwo));
        for (int i = 0; i < moreListCityOne.size(); i++) {
                assertEquals(moreListCityOne.get(i), moreListCityTwo.get(i));

        }
    }



//        searchPage.compareTwoLists(moreListCityOne, moreListCityTwo );

//    }
//        }


    @Ignore
    @Test
    public void marketQuantityElementsTest() {
        driver.get("https://market.yandex.ru/");
        marketPage.computerPage();
//        List<WebElement> value = marketPage.getCatalogComputers();
//        assertEquals(value, 48);


    }
}
