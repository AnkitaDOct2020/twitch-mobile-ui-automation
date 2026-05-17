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

    // First live channel card in search results
    private final By firstStreamer = By.xpath("(//img[@class='tw-image'])[1]/parent::div");

     // Video player element - confirms streamer page has loaded
    private final By videoPlayer = By.xpath("//video");

    public StreamerPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectFirstStreamer() {
        WebElement streamer = wait.until(
            ExpectedConditions.elementToBeClickable(firstStreamer)
        );
        // JavaScript click bypasses any overlapping elements
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", streamer);
    }

    public void waitForPageToLoad() {
        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        shortWait.until(ExpectedConditions.presenceOfElementLocated(videoPlayer));
    }
}