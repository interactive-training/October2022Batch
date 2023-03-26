package TestNGDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CustomerTest {


    @BeforeTest
    public void beforeTestCase(){
        System.out.println("Before test case exeuted in CustomerTest class");
    }

    @AfterTest
    public void afterTestCase(){
        System.out.println("After test case executed.");
    }

    @Test
    public  void method1(){
        System.out.println("Class1 , method 1  - test case executed.");
    }

    @Test
    public  void method2(){
        System.out.println("Class1 , method 2  - test case executed.");
    }

}
