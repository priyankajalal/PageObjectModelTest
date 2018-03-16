package tutorial.Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DropDown {
    static WebDriver driver;
    @BeforeMethod
    public static void test(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @Test
    public static void singleSelect(){
        driver.get("http://demo.guru99.com/test/newtours/register.php");

        WebElement ddElement= driver.findElement(By.xpath("//select[@name = 'country']"));
        Select select = new Select(ddElement);
        select.selectByVisibleText("INDIA");
   }
   @Test
   public static void multipleSelect(){
        driver.get("http://jsbin.com/osebed/2");
        WebElement fruits=driver.findElement(By.id("fruits"));
        Select select = new Select(fruits);
        select.selectByVisibleText("Banana");
        select.selectByIndex(1);
        //select.deselectByVisibleText("Banana");
   }
}
