package io.qase.page_object;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectsPage extends BasePage {

    @FindBy(id = "createButton")
    private WebElement createButton;

    public ProjectsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void createNewProject() {
        createButton.click();
    }
}
