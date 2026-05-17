package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ScrollUtils {

    private static final int SCROLL_AMOUNT = 600;
    private static final int SCROLL_PAUSE_MS = 1000;
    
    public static void scrollDown(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, arguments[0])", SCROLL_AMOUNT);

         try {
            Thread.sleep(SCROLL_PAUSE_MS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}