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
    NewsPage newsPage;

    @BeforeClass
    public void setUp() throws Exception {
        driver = new ChromeDriver();
        LoginPage LoginPage = PageFactory.init(driver, LoginPage.class);
        LoginPage.login();
        newsPage = PageFactory.init(driver, NewsPage.class);
        newsPage.newsTab.click();
    }

    @Test
    public void checkNewsCountTest() throws Exception {
        News news= newsPage.getNews();
        System.out.println(news);
    }

    @Test
    public void newsDateTest() throws Exception {
        newsPage.marketWatchTab.click();

        String latestNewsDate = newsPage.getNewsDate();
        String currentDate = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime());

        Assert.assertEquals(latestNewsDate, currentDate);

    }

}
