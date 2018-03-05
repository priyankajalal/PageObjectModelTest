package tutorial.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tutorial.pageobject.control.BaseControl;

public class BasePage {

    private WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        driver.manage().window().maximize();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public boolean isTextPresent(String text) {
        BaseControl ctrl = new BaseControl(this, By.xpath(""));
        return ctrl.exist();
    }


}
