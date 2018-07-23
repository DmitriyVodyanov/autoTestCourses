package autotest.test;

import autotest.base.BaseTest;
import autotest.page.LocationPage;
import autotest.page.MainPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestLocation extends BaseTest {

    private LocationPage locationPage;
    private MainPage mainPage;


    @BeforeClass
    public void beforeTest() {
        mainPage = PageFactory.initElements(driver, MainPage.class);
        locationPage = PageFactory.initElements(driver,LocationPage.class);
    }

    @Test
    public void compareTest() {

        mainPage.selectLocationMainPage();
        locationPage.selectCheckbox();
        locationPage.selectLocationMainPage("Лондон");
        mainPage.openMoreCatalog();
        System.out.println(mainPage.getMoreCatalog());

    }
}
