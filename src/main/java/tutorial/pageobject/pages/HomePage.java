package tutorial.pageobject.pages;

import org.openqa.selenium.WebDriver;
import tutorial.pageobject.helper.MyFindBy;
import tutorial.pageobject.control.BaseControl;

public class HomePage  extends BasePage{


    @MyFindBy(locator = "xpath=//td[contains(text(),'Naveen')]")
    public BaseControl userNameLabel;

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public boolean isUserPanelDisplayed(){
        this.getDriver().switchTo().frame("mainpanel");
        return userNameLabel.isDisplayed();
    }
}
