package autotest.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }

    public void initializeDriver() {
        String OS = System.getProperty("os.name");
        if (OS.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        } else
            System.setProperty("webdriver.chrome.driver", "./toolsLinux/chromedriver");
        driver.manage().window().maximize();
        driver.get("https://www.yandex.ru/");
    }

    public void waitForElement(By locator) {
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void clearFielByElement(By locator) {
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
}



