package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainPage extends BasePage {




    By moreButton = By.cssSelector("a[data-statlog='tabs.more']");
    By selectLocation = By.cssSelector("a[data-statlog='head.region.setup']");
    By more = By.className("home-tabs__more-item");
    ArrayList<String> moreCatalog = new ArrayList<String>();

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void selectLocationMainPage() {
        clickByElement(selectLocation);
    }

    public void openMoreCatalog() {
        clickByElement(moreButton);
    }

    public List getMoreCatalog() {
        return Collections.singletonList((moreCatalog));
    }

}
