package autotest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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

    public void scrollByElement(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actionsScroll = new Actions(driver);
        actionsScroll.moveToElement(element);
    }

    public void moveByElement(By locator) {
        waitForElement(locator);
        WebElement element = driver.findElement(locator);
        Actions moveElement = new Actions(driver);
        moveElement.moveToElement(element).build().perform();
    }

    public void selectByElement(By locator, String text) {
        Select selectElement = new Select(driver.findElement(locator));
        selectElement.selectByVisibleText(text);
    }

    public void backToPage() {
        driver.navigate().back();

    }
}
