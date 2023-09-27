import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.junit.*;

public class ProfileEditPage {

    private WebDriver driver;

    private By userName = By.xpath("//input[@id = 'owner-name']");
    private By userDescription = By.xpath("//input[@id = 'owner-description']");
    private By buttonSave = By.xpath("//button[@class = 'button popup__button']");

    public ProfileEditPage(WebDriver driver){
        this.driver = driver;
    }

    public void EnterNewValue(String description) {
        Assert.assertTrue(driver.findElement(userDescription)).isEnabled();
        driver.findElement(userDescription).clear();
        driver.findElement(userDescription).sendKeys(description);
    }

}
