package base;

import java.util.Map;
import java.util.HashMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.NoSuchElementException;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 12 Pro");
                
        WebDriverManager.chromedriver().clearDriverCache().setup();

        ChromeOptions options = new ChromeOptions();
        //options.setExperimentalOption("mobileEmulation", mobileEmulation);
        options.setBinary("/usr/bin/google-chrome");
        
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--remote-allow-origins=*");

        // IMPORTANT: DO NOT rely on system chromedriver anymore
        driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
 public void dismissModalIfPresent() {
        String[] closeSelectors = {
            "[data-a-target='modal-close-button']",
            "button[aria-label='Close']",
            "[data-a-target='player-overlay-mature-accept']",
            "[data-a-target='content-classification-gate-overlay-start-watching-button']"
        };

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        for (String selector : closeSelectors) {
            try {
                WebElement btn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector(selector))
                );
                btn.click();
                System.out.println("Modal dismissed: " + selector);
                break;
            } catch (TimeoutException | NoSuchElementException e) {
                // No modal with this selector, try next
            }
        }
    }
    
}