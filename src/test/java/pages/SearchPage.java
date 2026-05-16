package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class SearchPage {

    WebDriver driver;

    By searchIcon = By.xpath("//input[@aria-label='Search Input']");

    public SearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void search(String text) {
        driver.findElement(searchInput).sendKeys(text);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
    }
}