package autotest.tests;

import autotest.base.BaseTest;
import autotest.pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TestFirstExemple {

    WebDriver driver = new ChromeDriver();
    SearchPage searchPage = new SearchPage(driver);
    BaseTest baseTest = new BaseTest(driver);

    @Test
    public void SearchWeather() {
        baseTest.initializeDriver();
        searchPage.search("погода в пензе");
        assertTrue(searchPage.getResult().toLowerCase().contains("пензе"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
