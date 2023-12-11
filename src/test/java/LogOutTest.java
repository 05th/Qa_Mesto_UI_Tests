import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogOutTest {
    WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);

    @Before
    public void setUp() {
        driver.get("https://qa-mesto.praktikum-services.ru/");
        String email = "qatest@test.ru";
        String password = "test";
        loginPage.login(email, password);
    }
    @Test
    @DisplayName("Log Out Test")
    public void logOut() {
        homePage.waitForLoadProfileData();
        homePage.clickLogOutButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}