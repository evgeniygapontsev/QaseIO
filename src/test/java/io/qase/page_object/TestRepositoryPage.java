package io.qase.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestRepositoryPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div/div/div[2]/div/a[2]")
    private WebElement newCaseButton;
    @FindBy(css = "input[type='Text']")
    private WebElement inputTitle;
    @FindBy(css = "button[type='submit']")
    private WebElement saveButton;
    @FindBy(xpath = "//*[@id=\"case-1-in-suite-0\"]/div/div[2]/div[2]")
    private WebElement testCaseElement;
    @FindBy(css = "button[title='Delete case']")
    private WebElement deleteCaseButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div[14]/div/div/div/button[2]")
    private WebElement confirmDeleteCase;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/div/div[1]/ul[2]/li/a/span")
    private WebElement settingsOfProject;

    public TestRepositoryPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void createNewCase(String caseTitle) {
        newCaseButton.click();
        inputTitle.clear();
        inputTitle.sendKeys(caseTitle);
        saveButton.click();
    }

    public void deleteCase() {
        testCaseElement.click();
        deleteCaseButton.click();
        confirmDeleteCase.click();
    }

    public void openSettingsPage() {
        settingsOfProject.click();

    }
}
