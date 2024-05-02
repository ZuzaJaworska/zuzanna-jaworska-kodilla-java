package com.kodilla.testing2.crudapp;

import com.kodilla.testing2.config.WebDriverConfig;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CrudAppTestSuite {
    private static final String BASE_URL = "https://zuzajaworska.github.io/";
    private WebDriver driver;
    private Random generator;

    @BeforeEach
    public void initTests() {
        driver = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driver.get(BASE_URL);
        generator = new Random();
    }

    @AfterEach
    public void cleanUpAfterTest() {
        driver.close();
    }

    private String createCrudAppTestTask() throws InterruptedException {
        final String XPATH_TASK_NAME = "//form[@method = \"POST\"]/fieldset[1]/input";
        final String XPATH_TASK_CONTENT = "//form[@method = \"POST\"]/fieldset[2]/textarea";
        final String XPATH_ADD_BUTTON = "//form[@method = \"POST\"]/fieldset[3]/button";

        String taskName = "Task number " + generator.nextInt(100000);
        String taskContent = taskName + " content";

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement name = driver.findElement(By.xpath(XPATH_TASK_NAME));
        name.sendKeys(taskName);

        WebElement content = driver.findElement(By.xpath(XPATH_TASK_CONTENT));
        content.sendKeys(taskContent);

        WebElement addButton = driver.findElement(By.xpath(XPATH_ADD_BUTTON));
        addButton.click();
        Thread.sleep(2000);
        return taskName;
    }

    private void sendTestTaskToTrello(String taskName) throws InterruptedException {
        driver.navigate().refresh();
        while (!driver.findElement(By.xpath("//select[1]")).isDisplayed()) ;

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(theForm -> {
                    WebElement selectElement = theForm.findElement(By.xpath(".//select[1]"));
                    Select select = new Select(selectElement);
                    select.selectByIndex(1);

                    WebElement buttonCreateCard =
                            theForm.findElement(By.xpath(".//button[contains(@class, \"card-creation\")]"));
                    buttonCreateCard.click();
                });
        Thread.sleep(5000);
    }

    private boolean checkTaskExistsInTrello(String taskName) throws InterruptedException {
        final String TRELLO_URL = "https://trello.com/login";
        boolean result = false;
        WebDriver driverTrello = WebDriverConfig.getDriver(WebDriverConfig.FIREFOX);
        driverTrello.get(TRELLO_URL);

        Thread.sleep(4000);
        driverTrello.findElement(By.id("username")).sendKeys("zuzanna.ewa.lewandowska@gmail.com");
        WebElement el = driverTrello.findElement(By.id("login-submit"));
        el.submit();

        Thread.sleep(2000);
        driverTrello.findElement(By.id("password")).sendKeys("KODILLAkodilla0987");
        el.submit();

        Thread.sleep(6000);
        driverTrello.findElements(By.xpath("//a[@class=\"board-tile\"]")).stream()
                .filter(aHref -> !aHref.findElements(By.xpath(".//div[contains(@title, \"Kodilla\")]")).isEmpty())
                .findFirst()
                .ifPresent(WebElement::click);

        Thread.sleep(10000);
        result = driverTrello.findElements(By.xpath("//a")).stream()
                .anyMatch(theA -> theA.getText().equals(taskName));

        Thread.sleep(5000);
        driverTrello.close();

        return result;
    }

    public boolean deleteTestTaskFromCrud(String taskName) throws InterruptedException {
        boolean result = false;

        driver.navigate().refresh();

        Thread.sleep(5000);

        driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .filter(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName))
                .forEach(form -> {
                    WebElement button = form.findElement(By.xpath(".//button[@data-task-delete-button]"));
                    button.click();
                });

        Thread.sleep(5000);

        result = driver.findElements(
                        By.xpath("//form[@class=\"datatable__row\"]")).stream()
                .noneMatch(anyForm ->
                        anyForm.findElement(By.xpath(".//p[@class=\"datatable__field-value\"]"))
                                .getText().equals(taskName));

        Thread.sleep(5000);

        return result;
    }

    @Test
    public void shouldCreateTrelloCard() throws InterruptedException {
        String taskName = createCrudAppTestTask();
        sendTestTaskToTrello(taskName);
        assertTrue(checkTaskExistsInTrello(taskName));
        assertTrue(deleteTestTaskFromCrud(taskName));
    }
}