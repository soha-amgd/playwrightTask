package pages;

import com.microsoft.playwright.Page;

public class SignUpPage extends BasePage {

    private final String usernameField = "#sign-username";
    private final String passwordField = "#sign-password";
    private final String signUpSubmitButton = "button[onclick='register()']";

    public SignUpPage(Page page) {
        super(page);
    }

    public void register(String username, String password) {
        page.fill(usernameField, username);
        page.fill(passwordField, password);
        page.click(signUpSubmitButton);
        waitForTimeout(2000); // Adjust wait time
    }
}
