import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    // Create Web driver
    private WebDriver driver = new ChromeDriver();

    // Create Object Login Page class
    LoginPage loginPage = new LoginPage(driver);

    @Before
    public void setUp() {
        driver.get("https://qa-mesto.praktikum-services.ru/");
    }

    @DisplayName("LogIn Test")
    @Test
    public void loginTest() {
        loginPage.login("qatest@test.ru", "test");
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}