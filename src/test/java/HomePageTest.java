import org.hamcrest.MatcherAssert;
import static org.hamcrest.CoreMatchers.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {
    private WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    @Before
    public void setUp() {
        driver.get("https://qa-mesto.praktikum-services.ru/");
        String email = "qatest@mail.ru";
        String password = "test";
        loginPage.login(email, password);
    }
    @Test
    public void checkEmailInHeader() {
        homePage.waitForLoadHeader();
       String actualResult =  homePage.getTextEmailHeader();
       String expectedResult = "qatest@mail.ru";
        MatcherAssert.assertThat(actualResult, is(expectedResult));

    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
