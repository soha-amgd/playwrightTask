package tests;

import com.microsoft.playwright.*;

import java.util.Arrays;

public class BaseTest {
    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.firefox().launch(new BrowserType.LaunchOptions()
                .setArgs(Arrays.asList("--start-maximized"))
                .setHeadless(false)); // Set headless to false
        context = browser.newContext(new Browser.NewContextOptions()
                .setViewportSize(null));

        page = context.newPage();
    }

    public void tearDown() {
        browser.close();
        playwright.close();
    }
}
