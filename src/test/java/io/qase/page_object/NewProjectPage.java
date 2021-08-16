package io.qase.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewProjectPage extends BasePage{

    @FindBy(css = "input[type='text']")
    private WebElement projectName;
    @FindBy(css = "input[type='radio']")
    private WebElement accessTypePublic;
    @FindBy(css = "button[type='submit']")
    private WebElement createProjectButton;

    public NewProjectPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void newProject(String titleName) {
        projectName.clear();
        projectName.sendKeys(titleName);
        accessTypePublic.click();
        createProjectButton.click();

    }
}
