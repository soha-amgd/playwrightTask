package pages;

import com.microsoft.playwright.Page;

public class CartPage extends BasePage {

    private final String placeOrderButton = ".btn.btn-success";
    private final String nameField = "#name";
    private final String countryField = "#country";
    private final String cityField = "#city";
    private final String cardField = "#card";
    private final String monthField = "#month";
    private final String yearField = "#year";
    private final String purchaseButton = "button[onclick='purchaseOrder()']";

    public CartPage(Page page) {
        super(page);
    }

    public void placeOrder(String name, String country, String city, String card, String month, String year) {
        page.click(placeOrderButton);
        page.fill(nameField, name);
        page.fill(countryField, country);
        page.fill(cityField, city);
        page.fill(cardField, card);
        page.fill(monthField, month);
        page.fill(yearField, year);
        page.click(purchaseButton);
        waitForTimeout(2000); // Adjust wait time
    }
}
