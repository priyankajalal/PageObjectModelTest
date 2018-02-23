package com.chartlab.qa.util;


import com.chartlab.qa.base.TestBase;

public class TestUtil extends TestBase{
    /*Global variables: Can be used ANYWHERE*/

    /*These can even be define under Config.properties File*/
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }
}
