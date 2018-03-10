package tutorial.crm;


public class TestUtil extends BaseClass{

    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 10;

    public void switchToFrame(){
        driver.switchTo().frame("mainpanel");
    }

}
