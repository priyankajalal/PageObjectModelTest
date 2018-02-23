package com.chartlab.qa.base;


import com.chartlab.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/*This base class is Parent class*/
public class TestBase {

    /*Global variables: Can be used by all the methods and child classes*/
    public static WebDriver driver;
    public static Properties prop;

    /*Initializing Property file*/
    public TestBase()  {
        try{
            prop = new Properties();
            FileInputStream ip = new FileInputStream("C:\\projects\\selenium\\PageObjectModelTest\\src\\main\\java\\com\\chartlab\\qa\\config\\config.properties");
            prop.load(ip);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    /*Initializing Driver*/
    public static void initialization(){
        String browserName = prop.getProperty("browser");
        if(browserName.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(prop.getProperty("url"));
    }

}