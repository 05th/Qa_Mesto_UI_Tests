package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class HomePage extends BasePage{

    private By headerUserEmail = By.xpath("//p[@class = 'header__user']");
    private By logOutButton = By.xpath("//button[@class = 'header__logout']");
    private By profileImage = By.xpath("//div[@class = 'profile__image']");
    private By profileTitle = By.xpath("//h1[@class = 'profile__title']");
    private By profileDescription = By.xpath("//p[@class = 'profile__description']");
    private By profileEditButton = By.xpath("//button[@class = 'profile__edit-button']");
    private By profileCardAddButton = By.xpath("//button[@class = 'profile__add-button']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // Method for loading page


    @Override
    protected void waitForVisibility() {
        super.waitForVisibility();
    }

    // Method for get text from email header
    public String getTextEmailHeader() {
        return driver.findElement(headerUserEmail).getText();
    }

    // Method click on Profile edit button
    public void clickProfileEditButton() {
        driver.findElement(profileEditButton).click();
    }

    // Method for load profile data
    public void waitForLoadProfileData() {
        new WebDriverWait(driver, ofSeconds(10))
                .until(driver -> (driver.findElement(profileTitle).getText()
                        != null && !driver.findElement(profileTitle).getText().isEmpty()
                ));
    }

    // Method for wait, when is changing profile description data
    public void waitForChangedProfileDescription(String changed) {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(profileDescription, String.valueOf(changed)));
    }

    public void waitForChangedProfileTitle(String changed) {
        new WebDriverWait(driver, ofSeconds(10))
                .until(ExpectedConditions.textToBePresentInElementLocated(profileTitle, String.valueOf(changed)));
    }

    public void clickProfileImage() {
        driver.findElement(profileImage).click();
    }

    public void clickProfileCardAddButton() {
        driver.findElement(profileCardAddButton).click();
    }

    public void clickLogOutButton() {
        driver.findElement(logOutButton).click();
    }
}