package autotest.test;

import autotest.base.BaseTest;
import autotest.page.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
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
        driver.get("https://www.yandex.ru/");
        searchPage.searchWeather("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @Test
    public void compareListMoreTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocation("лондон");
        List<String> moreListCityOne = searchPage.getMoreCatalog();
        moreListCityOne.set(5,"asdfasd");
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
}
