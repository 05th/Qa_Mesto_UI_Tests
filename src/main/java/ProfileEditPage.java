import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.*;

public class ProfileEditPage {

    private WebDriver driver;

    private By userName = By.xpath("//input[@id = 'owner-name']");
    private By userDescription = By.xpath("//input[@id = 'owner-description']");
    private By buttonSave = By.xpath("//button[@class = 'button popup__button']");

    public ProfileEditPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method for check is Enabled field "description" && Clear this field && Send keys
    public void enterNewValueForDescription(String description) {
        Assert.assertTrue(driver.findElement(userDescription).isEnabled());
        driver.findElement(userDescription).clear();
        driver.findElement(userDescription).sendKeys(description);
    }

    // Method for check is Enabled field "username" && Clear this field && Send keys
    public void enterNewValueForTitle(String name) {
        Assert.assertTrue(driver.findElement(userName).isEnabled());
        driver.findElement(userName).clear();
        driver.findElement(userName).sendKeys(name);
    }

    // Method for check is Enabled "save" button && click on it
    public void clickButtonSave() {
        Assert.assertTrue(driver.findElement(buttonSave).isEnabled());
        driver.findElement(buttonSave).click();
    }
}