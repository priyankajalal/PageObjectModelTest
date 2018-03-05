package org.crm.qa;


import com.chartlab.qa.pages.HomePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrmLoginPage extends BaseClass{

    HomePage homePage;

    @FindBy(name = "username")
    WebElement userName;

    @FindBy(name = "password")
    WebElement pass;

    @FindBy(xpath="//input[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath="//img[contains(@class,'img-responsive')]")
    WebElement crmLogo;

    public CrmLoginPage(){
        PageFactory.initElements(driver,this);
    }

    public boolean validateCrmLogo(){
        return crmLogo.isDisplayed();
    }

    public CrmHomePage Login(){
        String username=prop.getProperty("username");
        String password=prop.getProperty("password");
        userName.sendKeys(username);
        pass.sendKeys(password);
        loginBtn.click();
        return new CrmHomePage();
    }
}
