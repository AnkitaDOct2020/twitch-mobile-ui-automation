package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SearchPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By searchInput = By.xpath("//input[@type='search']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void search(String text) {
        // Find fresh each time to avoid stale reference
        WebElement input = wait.until(
            ExpectedConditions.elementToBeClickable(searchInput)
        );
        input.sendKeys(text);

        // Re-find element before sending ENTER
        driver.findElement(searchInput).sendKeys(Keys.ENTER);

        // Re-find element before sending ESCAPE
        try {
            driver.findElement(searchInput).sendKeys(Keys.ESCAPE);
        } catch (Exception e) {
            // Input may have disappeared after Enter, that's fine
            System.out.println("Search input gone after Enter, continuing...");
        }
        // Wait for search results to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//h2[text()='Channels']")
        ));
    }
}