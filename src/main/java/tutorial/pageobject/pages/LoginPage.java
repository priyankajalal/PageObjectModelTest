package tutorial.pageobject.pages;

import org.openqa.selenium.WebDriver;
import tutorial.pageobject.helper.MyConfiguration;
import tutorial.pageobject.helper.MyFindBy;
import tutorial.pageobject.control.BaseControl;
import tutorial.pageobject.control.EditControl;

public class LoginPage extends BasePage {

    @MyFindBy(locator = "name=username")
    public EditControl userNameCtrl;
    @MyFindBy(locator = "name=password")
    public EditControl pwdCtrl;
    @MyFindBy(locator = "xpath=//input[@type='submit']")
    public BaseControl submitCtrl;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login() throws Exception {
        String url = MyConfiguration.get("url");
        this.getDriver().get(url);
        userNameCtrl.setText(MyConfiguration.get("username"));
        pwdCtrl.setText(MyConfiguration.get("password"));
        if (submitCtrl.isClickable()) {
            submitCtrl.click();
        }

    }

}
