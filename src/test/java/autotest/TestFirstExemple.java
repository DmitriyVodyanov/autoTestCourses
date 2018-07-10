package autotest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;

public class TestFirstExemple {

    WebDriver driver= new ChromeDriver();

    @BeforeClass
    public  void setUp() {
        System.setProperty("webdriver.chrome.driver", "~/IdeaProject/testexemple/chromedriver");
        System.setProperty("webdriver.chrome.driver", "~/IdeaProject/testexemple/chromedriver");
        driver.manage().window().maximize();
    }

    @Test
    public void SearchWeather() {

        driver.get("https://www.yandex.ru/");
        WebElement fieldInput = driver.findElement(By.id("text"));
        fieldInput.clear();
        fieldInput.sendKeys("погода в пензе");
        String weather = fieldInput.getText();
        WebElement searchButton = driver.findElement(By.cssSelector(".search2__button button"));
        searchButton.click();
        driver.quit();

    }

}
