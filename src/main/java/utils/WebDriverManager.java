package utils;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {
    public static WebDriver createWebdriver(String browser) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "path_to_geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "path_to_edgedriver.exe");
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unsupported browser! Supported browsers: Chrome, Firefox, Edge");
        }

        return driver;
    }

}
