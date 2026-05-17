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
    public void twitchStreamerFlowTest() {

        HomePage home = new HomePage(driver);
        SearchPage search = new SearchPage(driver);
        StreamerPage streamer = new StreamerPage(driver);

        // Step 1: Open Twitch in mobile view
        home.openTwitch();

        // Step 2: Navigate to search via Browse
        home.clickSearchIcon();

        // Step 3: Search for StarCraft II
        search.search("StarCraft II");

        // Navigate to live channels list
        home.clickViewAll();
        
        // Step 4: Scroll down 2 times within live channels
        ScrollUtils.scrollDown(driver);
        ScrollUtils.scrollDown(driver);

        // Step 5: Select first available streamer
        streamer.selectFirstStreamer();
       
         // Handle any modal or pop-up before video loads (mature content, age gate etc.)
        dismissModalIfPresent();

        streamer.waitForPageToLoad(); 
        
        // Step 6: // Take screenshot immediately
        ScreenshotUtils.capture(driver, "streamer_page_loaded");
    }
}