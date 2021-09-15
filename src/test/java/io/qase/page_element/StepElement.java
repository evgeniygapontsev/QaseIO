package io.qase.page_element;

import io.qase.value_object.StepData;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TextInput;


public class StepElement extends HtmlElement {

    @FindBy(xpath = ".//*[@id='actionGroup']//div[@contenteditable='true']/..")
    private TextInput actionElement;
    @FindBy(xpath = ".//*[@id='dataGroup']//div[@contenteditable='true']/..")
    private TextInput dataElement;
    @FindBy(xpath = ".//*[@id='expected_resultGroup']//div[@contenteditable='true']/..")
    private TextInput expectedResultElement;

    public void fillstep(StepData data) {

        actionElement.clear();
        actionElement.sendKeys(data.getAction());

        dataElement.clear();
        dataElement.sendKeys(data.getInputData());

        expectedResultElement.clear();
        expectedResultElement.sendKeys(data.getExpectedResult());
    }


}

