package tutorial.crm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public WebDriver driver;
    public  Properties prop;

    public BaseClass(){
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\projects\\selenium\\PageObjectModelTest\\src\\main\\java\\org\\crm\\qa\\crmConfig.properties");
            prop.load(ip);
            String browserName = prop.getProperty("browser");
            if(browserName.equals("chrome")){
                driver = new ChromeDriver();
            }else if(browserName.equals("firefox")){
                driver = new FirefoxDriver();
            }

            driver.get(prop.getProperty("url"));
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }



    public void verifyTitle(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Title incorrect");

    }

}
