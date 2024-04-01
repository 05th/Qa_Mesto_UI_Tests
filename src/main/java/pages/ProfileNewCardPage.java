package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileNewCardPage {
    private WebDriver driver;
    private By placeName = By.xpath("//*[@id = 'place-name']");
    private By placeLink = By.xpath("//*[@id = 'place-link']");
    private By buttonSavePlace = By.xpath("//*[@id='root']/div/div[2]/div/form/button[2]");

    // Constructor
    public ProfileNewCardPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method for check is Enabled field "place name" && Clear this field && Send keys
    public void enterNewPlaceName(String name) {
        Assert.assertTrue(driver.findElement(placeName).isEnabled());
        driver.findElement(placeName).clear();
        driver.findElement(placeName).sendKeys(name);
    }

    // Method for check is Enabled field "Card link" && Clear this field && Send keys
    public void enterNewCardLink(String link) {
        Assert.assertTrue(driver.findElement(placeLink).isEnabled());
        driver.findElement(placeLink).clear();
        driver.findElement(placeLink).sendKeys(link);
    }

    // Method for check is Enabled "save" button && click on it
    public void clickButtonSavePlace() {
        Assert.assertTrue(driver.findElement(buttonSavePlace).isEnabled());
        driver.findElement(buttonSavePlace).click();
    }
}
