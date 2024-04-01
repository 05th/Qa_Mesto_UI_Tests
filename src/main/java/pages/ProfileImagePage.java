package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileImagePage {
    private WebDriver driver;

    private By imageLink = By.xpath("//input[@id = 'owner-avatar']");
    private By saveButton = By.xpath("//div[@id='root']/div/div[4]/div/form/button[2]");

    // Constructor
    public ProfileImagePage(WebDriver driver) {
        this.driver = driver;
    }

    // Method for clear a placeholder && add new link
    public void addNewImageLink(String link) {
        Assert.assertTrue(driver.findElement(imageLink).isEnabled());
        driver.findElement(imageLink).clear();
        driver.findElement(imageLink).sendKeys(link);
    }

    // Method for check is Enabled "save" button && click on it
    public void clickSaveButton() {
        Assert.assertTrue(driver.findElement(saveButton).isEnabled());
        driver.findElement(saveButton).click();
    }
}