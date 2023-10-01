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
    ProfileEditPage profileEditPage = new ProfileEditPage(driver);
    ProfileImagePage profileImagePage = new ProfileImagePage(driver);

    @Before
    public void setUp() {
        driver.get("https://qa-mesto.praktikum-services.ru/");
        String email = "qatest@test.ru";
        String password = "test";
        loginPage.login(email, password);
    }

    @Test
    public void checkEmailInHeader() {
        homePage.waitForLoadHeader();
        String actualResult = homePage.getTextEmailHeader();
        String expectedResult = "qatest@test.ru";
        MatcherAssert.assertThat(actualResult, is(expectedResult));

    }

    @Test
    public void checkActivityByDescription() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileEditButton();
        String description = "SDET";
        profileEditPage.enterNewValueForDescription(description);
        profileEditPage.clickButtonSave();
        homePage.waitForChangedProfileDescription(description);
    }

    @Test
    public void checkActivityByTitle() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileEditButton();
        String title = "Uvasya";
        profileEditPage.enterNewValueForTitle(title);
        profileEditPage.clickButtonSave();
        homePage.waitForChangedProfileTitle(title);
    }

    @Test
    public void checkImageOnAvatarChanged() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileImage();
        String newLink = "https://sb-smart.ru/wp-content/uploads/9/e/e/9eec7a7829d53f220ec02b4e0b011eb9.jpeg";
        profileImagePage.addNewImageLink(newLink);
        profileImagePage.clickSaveButton();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}