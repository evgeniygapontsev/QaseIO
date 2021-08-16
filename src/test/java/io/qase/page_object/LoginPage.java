package io.qase.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = "input[type='email']")
    private WebElement inputEmail;
    @FindBy(css = "input[type='password']")
    private WebElement inputPassword;
    @FindBy(css = "button[type='submit']")
    private WebElement loginButton;

    public LoginPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        inputPassword.clear();
        inputPassword.sendKeys(password);
        loginButton.click();
    }

}
