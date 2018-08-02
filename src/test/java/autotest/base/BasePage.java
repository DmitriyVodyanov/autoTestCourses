package autotest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    public WebDriver driver;

    public BasePage(final WebDriver driver) {
        this.driver = driver;
    }

    public void waitForElement(By locator) {
        (new WebDriverWait(driver, 20)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clearFieldByElement(By locator) {
        waitForElement(locator);
        driver.findElement(locator).clear();
    }

    public void sendKeysByElement(By locator, String text) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(text);
    }

    public void clickByElement(By locator) {
        waitForElement(locator);
        driver.findElement(locator).click();
    }

    public void moveByElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void backToPage() {
        driver.navigate().back();
    }

    public String getByUrl() {
//        waitForElement(locator);
        return driver.getCurrentUrl();
    }

    public String resultValue(By locator) {

        return driver.findElement(locator).getAttribute("class");
    }

}
