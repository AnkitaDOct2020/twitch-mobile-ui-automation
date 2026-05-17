package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class StreamerPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public StreamerPage(WebDriver driver) {
        this.driver = driver;
    }

    // First live channel card in search results
    private final By firstStreamer = By.xpath("(//img[@class='tw-image'])[1]/parent::div");

    public void selectFirstStreamer() {
        WebElement streamer = wait.until(
            ExpectedConditions.elementToBeClickable(firstStreamer)
        );
        // JavaScript click bypasses any overlapping elements
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", streamer);
    }

    public void waitForPageToLoad() {
        // Wait for video player to confirm streamer page is fully loaded
        wait.until(ExpectedConditions.presenceOfElementLocated(videoPlayer));
    }
}