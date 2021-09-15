package io.qase.page_element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

import java.util.List;

@Name("Qase Select")
public class QaseSelect extends HtmlElement{
    @Name("menuElement")
    @FindBy(xpath = "./div")
    private HtmlElement menuElement;
    @Name("options")
    @FindBy(xpath = ".//*[contains(@id, 'option')]")
    private List<HtmlElement> options;


    public void selectByVisibleText(String text) {
        menuElement.click();

        WebElement targetOption = null;
        for (WebElement element :
                options) {
            if (element.getText().contains(text)) {
                targetOption = element;
            }
        }
        targetOption.click();
    }

}
