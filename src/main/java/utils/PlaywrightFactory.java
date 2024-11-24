package utils;

import com.microsoft.playwright.*;

import java.awt.*;


public class PlaywrightFactory {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext context;
    private Page page;

    public Page initBrowser(String browserType) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Extract the width and height
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        playwright = Playwright.create();
        switch (browserType.toLowerCase()) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions()
                        .setChannel("chrome") // Specifies Google Chrome
                        .setHeadless(false)); // Runs in non-headless mode
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Invalid browser type: " + browserType);
        }
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(screenWidth, screenHeight));
        page = context.newPage();
        return page;
    }

    public void closeBrowser() {
        browser.close();
        playwright.close();
    }
}
