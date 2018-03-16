package com.chartlab.testcases;

import com.chartlab.Data.SymbolDataProvider;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by vinodnayal on 14-03-2018.
 */
public class MyTest {


    @Test(dataProvider="symboldata",dataProviderClass = SymbolDataProvider.class)
    public void test(String name,String a,String f,String e){
        System.out.println(name);
    }
}
