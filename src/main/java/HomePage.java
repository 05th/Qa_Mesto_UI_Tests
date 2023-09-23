import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private By headerUserEmail = By.xpath("//p[@class = 'header__user']");
    private By signOutButton = By.xpath("//button[@class = 'header__logout']");
    private By profileImage = By.xpath("//div[@class = 'profile__image']");
    private By profileEditButton = By.xpath("//button[@class = 'profile__edit-button']");
    private By profileAddButton = By.xpath("//button[@class = 'profile__add-button']");


}
