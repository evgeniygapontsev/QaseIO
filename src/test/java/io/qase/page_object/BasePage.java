package io.qase.page_object;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected final WebDriver driver;

    public BasePage(){
        driver = DriverProvider.get();
    }

}
