package io.qase.page_element;

import io.qase.value_object.StepData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class StepElement {
    private WebDriver driver;
    private By selfLocator;
    private By actionInput = By.xpath(".//*[@id='actionGroup']//div[@contenteditable='true']/..");
    private By dataInput = By.xpath(".//*[@id='dataGroup']//div[@contenteditable='true']/..");
    ;
    private By expectedResultInput = By.xpath(".//*[@id='expected_resultGroup']//div[@contenteditable='true']/..");
    ;

    public StepElement(WebDriver driver, By selfLocator) {
        this.driver = driver;
        this.selfLocator = selfLocator;
    }

    public void fillstep(StepData data) {

        List<WebElement> selfCandidates = driver.findElements(selfLocator);
        WebElement self = selfCandidates.get(selfCandidates.size() - 1);
        WebElement actionElement = self.findElement(actionInput);
        actionElement.click();
        actionElement.clear();
        actionElement.sendKeys(data.getAction());

        WebElement dataElement = self.findElement(dataInput);
        dataElement.click();
        dataElement.clear();
        dataElement.sendKeys(data.getInputData());

        WebElement expectedResult = self.findElement(expectedResultInput);
        expectedResult.click();
        expectedResult.clear();
        expectedResult.sendKeys(data.getExpectedResult());
    }


}

