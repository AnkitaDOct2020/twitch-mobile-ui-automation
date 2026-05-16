package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    By searchIcon = By.xpath("//input[@aria-label='Search Input']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openTwitch() {
        driver.get("https://www.twitch.tv/");
    }

    public void clickSearchIcon() {
        driver.findElement(searchIcon).click();
    }
}