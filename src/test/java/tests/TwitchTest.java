package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchPage;
import pages.StreamerPage;
import utils.ScrollUtils;
import utils.ScreenshotUtils;

public class TwitchTest extends BaseTest {

    @Test
    public void twitchStreamerFlowTest() throws InterruptedException {

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        StreamerPage streamer = new StreamerPage(driver);

        // Step 1: Open Twitch
        home.openTwitch();
        Thread.sleep(4000);

        // Step 2: Search
        home.clickSearchIcon();
        Thread.sleep(2000);

        search.search("StarCraft II");
        Thread.sleep(4000);

        // Step 3: Scroll
        ScrollUtils.scrollDown(driver);
        Thread.sleep(2000);

        ScrollUtils.scrollDown(driver);
        Thread.sleep(2000);

        // Step 4: Select streamer
        streamer.selectFirstStreamer();
        Thread.sleep(5000);
        
        dismissModalIfPresent();
        Thread.sleep(2000);
        
        // Step 5: Screenshot
        ScreenshotUtils.capture(driver, "streamer_page_loaded");
    }
}