import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfileNewCardPage {
    private WebDriver driver;

    private By placeName = By.xpath("//*[@id = 'place-name']");
    private By placeLink = By.xpath("//*[@id = 'place-link']");
    private By buttonSavePlace = By.xpath("//*[@id='root']/div/div[2]/div/form/button[2]");

}
