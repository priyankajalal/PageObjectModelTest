package com.chartlab.testcases;

import com.chartlab.helper.PageFactory;
import com.chartlab.model.News;
import com.chartlab.pages.LoginPage;
import com.chartlab.pages.NewsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NewsTest {

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    public void checkNewsCountTest() throws Exception {
        LoginPage LoginPage = PageFactory.init(driver, LoginPage.class);
        LoginPage.login();
        NewsPage newsPage = PageFactory.init(driver, NewsPage.class);

        News news= newsPage.getNews();
        System.out.println(news);
    }
    @Test
    public void newsDateTest() throws Exception {
        LoginPage LoginPage = PageFactory.init(driver, LoginPage.class);
        LoginPage.login();
        NewsPage newsPage = PageFactory.init(driver, NewsPage.class);
        newsPage.newsTab.click();
        newsPage.marketWatchTab.click();

        String latestNewsDate = newsPage.getNewsDate();
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

        Assert.assertEquals(latestNewsDate, currentDate);

    }

}
