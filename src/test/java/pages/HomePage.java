package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    //By searchIcon = By.xpath("//input[@aria-label='Search Input']");
    By searchIcon = By.xpath("//div[text()='Browse']");
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