import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileEditPage {

    private WebDriver driver;

    private By userNameEdit = By.xpath("//input[@id = 'owner-name']");
    private By userDescriptionEdit = By.xpath("//input[@id = 'owner-description']");
    private By buttonProfileChangeSave = By.xpath("//button[@class = 'button popup__button']");

    public ProfileEditPage(WebDriver driver){
        this.driver = driver;
    }


}
