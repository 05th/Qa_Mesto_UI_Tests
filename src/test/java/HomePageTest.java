import io.qameta.allure.junit4.DisplayName;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;

public class HomePageTest {
    private WebDriver driver = new ChromeDriver();
    LoginPage loginPage = new LoginPage(driver);
    HomePage homePage = new HomePage(driver);
    ProfileEditPage profileEditPage = new ProfileEditPage(driver);
    ProfileImagePage profileImagePage = new ProfileImagePage(driver);
    ProfileNewCardPage profileNewCardPage = new ProfileNewCardPage(driver);

    @Before
    public void setUp() {
        driver.get("https://qa-mesto.praktikum-services.ru/");
        String email = "qatest@test.ru";
        String password = "test";
        loginPage.login(email, password);
    }

    @Test
    @DisplayName("Check Email in Header")
    public void checkEmailInHeader() {
        homePage.waitForLoadHeader();
        String actualResult = homePage.getTextEmailHeader();
        String expectedResult = "qatest@test.ru";
        MatcherAssert.assertThat(actualResult, is(expectedResult));

    }

    @Test
    @DisplayName("Change description in user")
    public void checkActivityByDescription() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileEditButton();
        String description = "SDET";
        profileEditPage.enterNewValueForDescription(description);
        profileEditPage.clickButtonSave();
        homePage.waitForChangedProfileDescription(description);
    }

    @Test
    @DisplayName("Change name in user")
    public void checkActivityByTitle() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileEditButton();
        String title = "Uvasya";
        profileEditPage.enterNewValueForTitle(title);
        profileEditPage.clickButtonSave();
        homePage.waitForChangedProfileTitle(title);
    }
    @Test
    @DisplayName("Change avatar image in user")
    public void checkImageOnAvatarChanged() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileImage();
        String newLink = "https://sb-smart.ru/wp-content/uploads/9/e/e/9eec7a7829d53f220ec02b4e0b011eb9.jpeg";
        profileImagePage.addNewImageLink(newLink);
        profileImagePage.clickSaveButton();
    }
    @Test
    @DisplayName("Add new card on home page")
    public void addNewPlaceCard() {
        homePage.waitForLoadProfileData();
        homePage.clickProfileCardAddButton();
        String newName = "Moscow";
        String newLink = "https://sportishka.com/uploads/posts/2022-04/1650612987_17-sportishka-com-p-sovremennaya-moskva-krasivo-foto-18.jpg";
        profileNewCardPage.enterNewPlaceName(newName);
        profileNewCardPage.enterNewCardLink(newLink);
        profileNewCardPage.clickButtonSavePlace();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}