package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import java.time.Duration;
/**
 * Базовый класс для всех страниц, содержит общие методы.
 */

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Конструктор базового класса
    public BasePage(WebDriver driver) {
        this.driver = driver;
        // Инициализация явных ожиданий
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Метод для открытия URL
    public void open(String url) {
        driver.get(url);
    }

    // Метод для ожидания видимости элемента
    protected void waitForVisibility() {
        wait.until(driver -> driver.findElement(locator).isDisplayed());
    }

    // Метод для клика по элементу
    protected void click(By locator) {
        waitForVisibility();
        driver.findElement(locator).click();
    }

    // Метод для ввода текста в элемент
    protected void type(By locator, String text) {
        waitForVisibility();
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    // Метод для получения текста элемента
    protected String getText(By locator) {
        waitForVisibility();
        return driver.findElement(locator).getText();
    }
}