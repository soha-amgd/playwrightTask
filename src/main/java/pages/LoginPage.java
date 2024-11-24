package pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {

    private final String usernameField = "#loginusername";
    private final String passwordField = "#loginpassword";
    private final String loginSubmitButton = "button[onclick='logIn()']";

    public LoginPage(Page page) {
        super(page);
    }

    public void login(String username, String password) {
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(loginSubmitButton);
        waitForTimeout(2000); // Adjust wait time
    }
}
