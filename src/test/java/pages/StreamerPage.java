package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StreamerPage {

    WebDriver driver;

    public StreamerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectFirstStreamer() {
        driver.findElement(By.xpath("//div[@data-target='directory-first-item']")).click();
    }
}