package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class SearchPage {

    WebDriver driver;
    By searchInput = By.xpath("//input[@type='search']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollWithinLiveChannels() {
     ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
        try { Thread.sleep(1000); } catch (Exception e) {}
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 300)");
}
    public void search(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Find fresh each time to avoid stale reference
        WebElement input = wait.until(
            ExpectedConditions.elementToBeClickable(searchInput)
        );
        input.sendKeys(text);

        // Re-find element before sending ENTER
        driver.findElement(searchInput).sendKeys(Keys.ENTER);

        // Re-find element before sending ESCAPE
        try {
            Thread.sleep(1000);
            driver.findElement(searchInput).sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
            // Input may have disappeared after Enter, that's fine
            System.out.println("Search input gone after Enter, continuing...");
        }
    }
}