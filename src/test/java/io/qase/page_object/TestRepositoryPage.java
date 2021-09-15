package io.qase.page_object;

import io.qase.page_element.QaseSelect;
import io.qase.page_element.StepElement;
import io.qase.value_object.StepData;
import io.qase.value_object.TestCaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TestRepositoryPage extends BasePage {

    @FindBy(css = ".suitecase-step")
    private StepElement stepElement;

    @FindBy(xpath = "//*[@id=\"react-app\"]/div/div/div/div/div[2]/div/a[2]")
    private WebElement newCaseButton;
    @FindBy(css = "input[type='Text']")
    private WebElement inputTitle;
//    @FindBy(xpath = "//*[@id=\"statusGroup\"]/div[1]/div/div[1]")
//    private WebElement dropdownStatus;
//    @FindBy(xpath = "//div[text()='Actual']")
//    private WebElement dropdownStatusActual;
    @FindBy(css = "p[data-placeholder='For example: We can authorize on page http://example.com/login']")
    private WebElement inputDescription;
//    @FindBy(xpath = "//*[@id=\"severityGroup\"]/div[1]/div/div[1]")
//    private WebElement dropdownSeverity;
//    @FindBy(xpath = "//div[text()='Blocker']")
//    private WebElement dropdownSeverityBlocker;
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
    @FindBy(css = "span[class='submenu-item-text']")
    private WebElement testRuns;
    @FindBy(css = "a#add-step")
    private WebElement addStepButton;
    @FindBy(css = "p[data-placeholder='For example: Open Sign in page']")
    private WebElement inputAction;
    @FindBy(css = "p[data-placeholder='For example: Login / password']")
    private WebElement inputData;
    @FindBy(css = "p[data-placeholder='For example: popup is opened']")
    private WebElement inputExpectedResult;

    private static String selectLocatorTemplate = "[id='%sGroup']";


    public TestRepositoryPage() {
        super();
        PageFactory
        PageFactory.initElements(driver, this);
    }

    public void createNewCase(TestCaseData data) {
        newCaseButton.click();
        inputTitle.clear();
        inputTitle.sendKeys(data.getTitle());
        pickStatus(data.getStatus());
        inputDescription.sendKeys(data.getDescription());
        pickSeverity(data.getSeverity());


        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_PAGE_DOWN);
        robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.PAGE_DOWN);

        Actions actions = new Actions(driver);
        for (StepData stepData :
                data.getStepDataList()) {
//            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", addStepButton);
//            actions.moveToElement(addStepButton).click().perform();
            addStepButton.click();
            stepElement.fillstep(stepData);
        }

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

    public void createTestRun() {
        testRuns.click();
    }

    private void pickStatus(Status status) {
        QaseSelect dropdownStatusSelect = new QaseSelect(
                driver,
                By.cssSelector(String.format(selectLocatorTemplate, "status")
                )
        );
        if (Status.DRAFT.equals(status)){
            dropdownStatusSelect.selectByVisibleText("Draft");
        }
    }
    private void pickSeverity(Severity severity) {
        QaseSelect dropdownSeveritySelect = new QaseSelect(
                driver,
                By.cssSelector(String.format(selectLocatorTemplate, "severity")
                )
        );
        if (Severity.BLOCKER.equals(severity)){
            dropdownSeveritySelect.selectByVisibleText("Blocker");
        }
    }

    public enum Status {
        ACTUAL, DRAFT, DEPRECATED
    }

    public enum Severity {
        NORMAL, BLOCKER
    }
}
