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
            By.xpath("(//img[@class='tw-image'])[1]")
        ));
        streamer.click();
    }
}