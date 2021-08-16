package io.qase.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage extends BasePage{
    @FindBy(className = "btn-cancel")
    private WebElement deleteProjectButton;

    public SettingsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void deleteProject() {
        deleteProjectButton.click();
        deleteProjectButton.click();
    }

}
