package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class SearchPage {

    WebDriver driver;

    By searchInput = By.xpath("//input[@type='search']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String text) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement input = wait.until(
            ExpectedConditions.elementToBeClickable(searchInput)
        );
        input.sendKeys(text);
        input.sendKeys(Keys.ENTER);
        
        // Dismiss keyboard/search overlay so it doesn't block results
        input.sendKeys(Keys.ESCAPE);
    }
}