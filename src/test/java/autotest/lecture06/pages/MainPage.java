package autotest.lecture06.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    By location = By.className("geolink__reg");
    By linkMore = By.cssSelector("div[role=\"navigation\"] a:nth-child(9)");
    By catalogMore = By.cssSelector(".home-tabs__more");


    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getResult() {
        return driver.findElement(catalogMore).getText();
    }
}
