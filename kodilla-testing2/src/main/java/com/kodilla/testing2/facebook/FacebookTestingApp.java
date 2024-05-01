package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES_ACCEPT =
            "//div[contains(@class, \"_4-i2\")]/div[@class = \"_al64\"]/button[@data-cookiebanner = \"accept_button\"]";
    private static final String XPATH_CREATE_ACCOUNT = "//form[@class = \"_9vtf\"]/div[@class = \"_6ltg\"]/a";
    private static final String XPATH_BIRTHDAY_DAY = "//div[@class = \"_5k_5\"]/span/span/select[@id = \"day\"]";
    private static final String XPATH_BIRTHDAY_MONTH = "//div[@class = \"_5k_5\"]/span/span/select[@id = \"month\"]";
    private static final String XPATH_BIRTHDAY_YEAR = "//div[@class = \"_5k_5\"]/span/span/select[@id = \"year\"]";

    public static void main(String[] args) {

        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        assert driver != null;
        driver.get("https://www.facebook.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        boolean cookiesClicked = false;
        while (!cookiesClicked) {
            try {
                wait.until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_COOKIES_ACCEPT))).click();
                cookiesClicked = true;
            } catch (Exception e) {
                driver.navigate().refresh();
            }
        }

        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        WebElement selectComboDay = driver.findElement(By.xpath(XPATH_BIRTHDAY_DAY));
        Select selectDay = new Select(selectComboDay);
        selectDay.selectByValue("21");

        WebElement selectComboMonth = driver.findElement(By.xpath(XPATH_BIRTHDAY_MONTH));
        Select selectMonth = new Select(selectComboMonth);
        selectMonth.selectByValue("3");

        WebElement selectComboYear = driver.findElement(By.xpath(XPATH_BIRTHDAY_YEAR));
        Select selectYear = new Select(selectComboYear);
        selectYear.selectByValue("1905");
    }
}
