package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import java.time.Duration;

public class StreamerPage {

    private WebDriver driver;

    public StreamerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstStreamer() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement streamer = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("(//div[@data-a-target='search-result-live-channel'])[1]")
        ));
        streamer.click();
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
                // No modal found with this selector, try next
            }
        }
    }
}