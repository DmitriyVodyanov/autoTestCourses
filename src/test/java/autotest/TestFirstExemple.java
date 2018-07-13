package autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;


public class TestFirstExemple {

    WebDriver driver = new ChromeDriver();

    @BeforeClass
    public  void setUp() {
        String OS = System.getProperty("os.name");
        if (OS.toLowerCase().contains("windows")) {
            System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe"); //initializing the driver in the operating system for Antichrists
        } else
            System.setProperty("webdriver.chrome.driver", "./toolsLinux/chromedriver"); //initializing the driver in the operating system for Orthodox
        driver.manage().window().maximize();
    }

    @Test
    public void SearchWeather() {
        driver.get("https://www.yandex.ru/");
        WebElement fieldInput = driver.findElement(By.id("text"));
        fieldInput.clear();
        fieldInput.sendKeys("погода в пензе");
        WebElement searchButton = driver.findElement(By.cssSelector(".search2__button button"));
        searchButton.click();
        WebElement firstLink = driver.findElement(By.cssSelector(".serp-item:nth-child(3)  .organic__url"));
        String linkPage = firstLink.getText();
        assertTrue(linkPage.toLowerCase().contains("пензе"));

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
