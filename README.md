# twitch-mobile-ui-automation
Selenium-based UI automation framework for Twitch, running in Chrome with iPhone 12 Pro mobile emulation.

## Test Execution - 
<img width="1280" height="670" alt="TwitchTest" src="https://github.com/user-attachments/assets/027a1349-1bcb-4580-97c4-9bfdec0daf0c" />




## Test Case
| Step | Description |
|------|-------------|
| 1 | Navigate to Twitch |
| 2 | Click search icon (Browse) |
| 3 | Search for StarCraft II |
| 4 | Scroll down 2 times |
| 5 | Select first live streamer |
| 6 | Wait for page to load and take screenshot |


```
twitch-mobile-ui-automation
├── src/
│   └── test/
│       └── java/
│           ├── base/
│           │   └── BaseTest.java         # Driver setup, mobile emulation,
│           │                             # framework-level modal handler
│           ├── pages/
│           │   ├── HomePage.java         # Twitch homepage actions
│           │   ├── SearchPage.java       # Search functionality
│           │   └── StreamerPage.java     # Streamer page actions
│           ├── tests/
│           │   └── TwitchTest.java       # Main test case
│           └── utils/
│               ├── ScrollUtils.java      # Page scrolling helper
│               └── ScreenshotUtils.java  # Screenshot capture helper
├── screenshots/                          # Auto-generated test screenshots
├── assets/                               # GIF and other assets
└── pom.xml                               # Maven dependencies
```
## Tech Stack
- Java
- Selenium WebDriver
- TestNG
- Chrome DevTools Mobile Emulation (iPhone 12 Pro)
- Maven

## Prerequisites
- Java 21+
- Maven
- Google Chrome
- ChromeDriver (managed by WebDriverManager)

## How to Run
```bash
mvn clean test
```
## Framework Design
- **Page Object Model (POM)** — each page has its own class with 
  locators and actions separated from test logic
- **BaseTest** — handles driver setup, teardown, and framework-level 
  modal/popup handling inherited by all tests
- **Mobile Emulation** — Chrome configured with iPhone 12 Pro device 
  profile to simulate real mobile browser behavior
- **Explicit Waits** — WebDriverWait used throughout to eliminate 
  flakiness, no hardcoded Thread.sleep in test flow
- **Screenshot Utility** — auto-creates directory, appends timestamp 
  to avoid overwriting previous captures
