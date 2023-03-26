package TestNGDemo;

import org.testng.annotations.*;

public class AccountsTest {

    @BeforeSuite
    public void beforesuite(){
        System.out.println("Before Suite exeuted in AccountsTest");
    }

    @BeforeClass
    public void beforeclass(){
        System.out.println("Before Class exeuted in AccountsTest");
    }

    @BeforeTest
    public void beforeTestCase(){
        System.out.println("Before test  exeuted in AccountsTest");
    }


    @Test (groups = { "sanity"})
    public void method1(){
        System.out.println("AccountsTest - > method1 - test case executed.");
    }


    @Test()
    public void method2(){
        System.out.println("AccountsTest - > method1 - test case executed.");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method  exeuted in AccountsTest");
    }

}
