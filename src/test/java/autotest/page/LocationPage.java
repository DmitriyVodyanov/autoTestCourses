package autotest.page;

import autotest.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LocationPage extends BasePage {

    By inputLocation = By.id("city__front-input");
    By inputlocationCity = By.cssSelector(".popup__items li:nth-child(1)");
    By checkboxLocation = By.className("checkbox__control");

    public LocationPage(WebDriver driver) {
        super(driver);
    }

    public void selectCheckbox() {
        if (checkboxLocation != null) {
            clickByElement(checkboxLocation);
        }

    }

    public void selectLocationMainPage (String text) {
        clearFieldByElement(inputLocation);
        sendKeysByElement(inputLocation, text);
        clickByElement(inputlocationCity);

    }


}
