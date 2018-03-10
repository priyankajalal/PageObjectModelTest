package tutorial.chartlab_test.pages;


import tutorial.chartlab_test.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    /*Page Factory or Object Repository*/
    @FindBy(name="username")
    @CacheLookup
    WebElement user;

    @FindBy(name="password")
    @CacheLookup
    WebElement pass;

    @FindBy(xpath="//input[@type='submit']")
    @CacheLookup
    WebElement loginBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    /*Initializing the Login Page Objects*/
    /*Here 'this' means the Current class Objects or elements*/
    public LoginPage(){
        PageFactory.initElements(driver,this);
    }

    //Actions :
    public boolean validateCRMImage(){
        return crmLogo.isDisplayed();
    }

    public HomePage login(String un,String pwd) throws InterruptedException {
        user.sendKeys(un);
        pass.sendKeys(pwd);
        Thread.sleep(2000);
        loginBtn.click();

        return new HomePage();
    }
}







