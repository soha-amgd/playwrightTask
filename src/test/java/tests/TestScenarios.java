package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.time.Instant;
import java.util.Date;
import java.util.Timer;

public class TestScenarios extends BaseTest {
    private HomePage homePage;
    private SignUpPage signUpPage;
    private LoginPage loginPage;
    private CartPage cartPage;
    Instant instant
            = Instant.parse("2018-12-30T19:34:50.63Z");

    String uniqueUsername = "testuser_" + instant.toEpochMilli();

    @BeforeMethod
    public void initialize() {
        setUp();
        homePage = new HomePage(page);
        signUpPage = new SignUpPage(page);
        loginPage = new LoginPage(page);
        cartPage = new CartPage(page);
        homePage.navigateTo("https://www.demoblaze.com/");
    }

    @AfterMethod
    public void cleanUp() {
        tearDown();
    }

    @Test(priority = 0)
    public void testUserRegistration() {
        homePage.openSignUpForm();
        signUpPage.register(uniqueUsername, "testpassword");
        //Assert.assertEquals("Sign up successful.", alertText, "Unexpected alert message!");

    }

    @Test(priority = 1)
    public void testUserLogin() {
        homePage.openLoginForm();
        loginPage.login(uniqueUsername, "testpassword");
        Assert.assertEquals(homePage.getWelcomeMsg(),"Welcome "+uniqueUsername);
    }

    @Test(priority = 2)
    public void testUserLogout() {
        homePage.openLoginForm();
        loginPage.login(uniqueUsername, "testpassword");
        homePage.logout();
        Assert.assertTrue(homePage.isLoginBtnExist());
    }

    @Test(priority = 3)
    public void testPlaceOrderForAppleMonitor() {
        homePage.openLoginForm();
        loginPage.login(uniqueUsername, "testpassword");
        homePage.selectAppleMonitor();
        homePage.addToCart();
        homePage.navigateToCart();
        cartPage.placeOrder("John Doe", "USA", "New York", "1234567890123456", "12", "2025");

        String thankYouMessageText = page.locator("h2:has-text('Thank you for your purchase!')").innerText();
        Assert.assertTrue(thankYouMessageText.contains("Thank you for your purchase!"), "Thank you message is not displayed!");
    }
}
