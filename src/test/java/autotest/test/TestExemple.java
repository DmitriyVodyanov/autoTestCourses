package autotest.test;

import autotest.base.BaseTest;
import autotest.page.LocationPage;
import autotest.page.SearchPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import static org.testng.Assert.assertTrue;

public class TestExemple extends BaseTest {

    private SearchPage searchPage;
    private LocationPage locationPage;

    @BeforeClass
    public void beforeTest() {
        searchPage = PageFactory.initElements(driver, SearchPage.class);
//        mainPage = PageFactory.initElements(driver, MainPage.class);
        locationPage = PageFactory.initElements(driver, LocationPage.class);
    }

    @Test
    public void SearchWeather() {
//        driver.get("https://www.yandex.by/");
        searchPage.searchWeather("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @Test
    public void compareListTest() {
        driver.get("https://www.yandex.ru/");
        searchPage.selectLocationMainPage();
//        locationPage.selectCheckbox();
        locationPage.selectLocation("лондон");
        searchPage.openMoreCatalog();
//        System.out.println(mainPage.getMoreCatalog());
        searchPage.selectLocationMainPage();
//        locationPage.selectCheckbox();
        locationPage.selectLocation(" париж");
//        searchPage.openMoreCatalog();


    }
}
