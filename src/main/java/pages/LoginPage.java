package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// How to create Page Object Model (POM)

// 1. Create a login page class
public class LoginPage {

    // 2. Add a private field Driver to the class
    private WebDriver driver;

    // 3. Create Locators
    private By emailField = By.xpath("//input[@id = 'email']");
    private By passwordField = By.xpath("//input[@id = 'password']");
    private By signInButton = By.xpath("//button[@class = 'auth-form__button']");
    private By singUpButton = By.xpath("//a[@class = 'header__auth-link']");

    // 4. Create Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // 5. Create methods for locators
    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public boolean checkSignInIsEnabled() {
        return driver.findElement(signInButton).isEnabled();
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    public void clickSignUpButton() {
        driver.findElement(singUpButton).click();
    }


    // Combine methods into a step
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickSignInButton();
    }
}