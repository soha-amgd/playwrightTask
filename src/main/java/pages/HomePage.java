package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    private final String signUpButton = "#signin2";
    private final String loginButton = "#login2";
    private final String logoutButton = "#logout2";
    private final String appleMonitorLink = "text=Apple monitor 24";
    private final String addToCartButton = ".btn.btn-success";
    private final String cartLink = "#cartur";

    public HomePage(Page page) {
        super(page);
    }

    public void openSignUpForm() {
        page.click(signUpButton);
    }

    public void openLoginForm() {
        page.click(loginButton);
    }

    public void logout() {
        page.click(logoutButton);
    }

    public void selectAppleMonitor() {
        page.locator("text=Monitors").click();
        page.click(appleMonitorLink);
    }

    public void addToCart() {
        page.click(addToCartButton);
    }

    public void navigateToCart() {
        page.click(cartLink);
    }

    public String getWelcomeMsg(){
       return page.locator("#nameofuser").innerText();
    }

    public boolean isLoginBtnExist(){
        try {
            // Check if the element exists and is visible
            Locator button = page.locator(loginButton);
            return button.count() > 0 ;
        } catch (Exception e) {
            return false;
        }
    }
}
