package pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class HomePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Mobile view uses Browse (bottom nav) as entry point to search
    private final By browseIcon = By.xpath("//div[text()='Browse']");
    private final By viewAllChannels = By.xpath("//h2[text()='Channels']/following-sibling::a/p");
    
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void openTwitch() {
        driver.get("https://www.twitch.tv/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(browseIcon));
    }

    public void clickSearchIcon() {
        wait.until(ExpectedConditions.elementToBeClickable(browseIcon)).click();
    }
    public void clickViewAll() {
        wait.until(ExpectedConditions.elementToBeClickable(viewAllChannels)).click();
    }

}