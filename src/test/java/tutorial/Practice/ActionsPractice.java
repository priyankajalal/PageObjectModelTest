package tutorial.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class ActionsPractice {

    public static WebDriver driver;

    public static void main(String args[]){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.chartlabpro.com");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.xpath("//input[@id='LoginForm_username']"));
        username.sendKeys("vinodnayal");
        WebElement pass=driver.findElement(By.xpath("//input[@id='LoginForm_password']"));
        pass.sendKeys("p0o9i8u7");
        WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));

        String bgColor = loginBtn.getCssValue("color");
        System.out.println("Before hover: "+bgColor);
        Actions action = new Actions(driver);
        action.moveToElement(loginBtn).build().perform();
        System.out.println("After hover: "+bgColor);

    }
}



