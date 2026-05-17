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
        options.setExperimentalOption("mobileEmulation", mobileEmulation);
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
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        String[] closeSelectors = {
            "[data-a-target='modal-close-button']",
            "button[aria-label='Close']",
            "[data-a-target='player-overlay-mature-accept']",
            "[data-a-target='content-classification-gate-overlay-start-watching-button']"
        };

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
    public void dismissOpenAppBannerIfPresent() {
    try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        
        // Common selectors for the "Open App" banner close/dismiss button
        String[] bannerSelectors = {
            "[data-a-target='dismiss-button']",
            "button[aria-label='Dismiss']",
            "[data-a-target='mobile-continue-in-browser']",  // "Continue in browser" link
            "a[data-a-target*='browser']",
            "//*[contains(text(),'Continue in browser')]",   // text-based
            "//*[contains(text(),'Not now')]"
        };

        for (String selector : bannerSelectors) {
            try {
                WebElement btn;
                if (selector.startsWith("//") || selector.startsWith("//*")) {
                    btn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.xpath(selector)
                    ));
                } else {
                    btn = wait.until(ExpectedConditions.elementToBeClickable(
                        By.cssSelector(selector)
                    ));
                }
                btn.click();
                System.out.println("Banner dismissed: " + selector);
                Thread.sleep(2000);
                break;
            } catch (TimeoutException | NoSuchElementException | InterruptedException e) {
                // Try next selector
            }
        }
    } catch (Exception e) {
        System.out.println("No Open App banner found, continuing...");
    }
}
    
}