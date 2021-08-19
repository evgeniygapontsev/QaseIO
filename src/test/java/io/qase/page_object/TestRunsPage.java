package io.qase.page_object;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TestRunsPage extends BasePage{

    @FindBy(id = "start-new-test-run-button")
    private WebElement startButton;
    @FindBy(css = "input[type='Text']")
    private WebElement inputRunTitle;
    @FindBy(css = "button[type='button']")
    private WebElement addCasesButton;

    @FindBy(css = "button[type='submit']")
    private WebElement startRunButton;

    public TestRunsPage() {
        super();
        PageFactory.initElements(driver, this);
    }

    public void startNewTestRun(String runTitle) {
        startButton.click();
        inputRunTitle.sendKeys(runTitle);
        addCasesButton.click();

        startRunButton.click();
    }
}
