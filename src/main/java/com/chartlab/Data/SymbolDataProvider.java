package com.chartlab.Data;

import org.testng.annotations.DataProvider;

public class SymbolDataProvider {

    @DataProvider(name = "symboldata2")
    public  Object[][] testData2(){
        return new Object[][]
                { { "testuser_1", "Test@123" }, { "testuser_1", "Test@123" }};

    }

    @DataProvider(name = "symboldata")
    public static Object[][] testData(){
        return new Object[][] {
                {"Microsoft Corporation (MSFT)","93.85","-0.56","-0.59%"}
        };
//        Object[][] obj=new Object[1][1];
//        obj[0][1]="Microsoft Corporation (MSFT)";
//        //obj[0][2]= 96.07;
//        //obj[0][3]= 1.64;
//        //obj[0][4]="1.74%";
    }
}
