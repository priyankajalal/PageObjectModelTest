package tutorial.Practice;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class BrokenLinks {

    public static void main(String args[]){
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        String homepage = "http://www.chartlabpro.com/";
        driver.get(homepage);

        List<WebElement> links=driver.findElements(By.tagName("a"));
        links.addAll(driver.findElements(By.tagName("img")));
        System.out.println("Total links are "+links.size());

        HttpURLConnection huc = null;
        int respCode = 200;

        for (WebElement link: links){
            String url = link.getAttribute("href");
            if(url==null){
                System.out.println(url+ " :This URL is either not configured for anchor tag or it is empty");
                continue;
            }
            if(!url.startsWith(homepage)){
                System.out.println(url+ " :This URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if(respCode >= 400){
                    System.out.println(link.getText()+ " :This is a Broken Link");
                }else{
                    System.out.println(link.getText()+ " :This is a Valid Link");
                }

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }
    }

