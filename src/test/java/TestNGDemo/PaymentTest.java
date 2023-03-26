package TestNGDemo;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class PaymentTest {

    @BeforeTest
    public void beforepayment(){
        System.out.println("Before test in payments");
    }

    @AfterTest
    public void afterpayment(){
        System.out.println("After payment test");
    }

    @Test (groups = {"regression", "sanity"})
    public void paymentTest1(){
        System.out.println("----->Payment test 1 executed.");
    }

    @Test (description = "sdfads" , groups = { "sanity"})
    public void paymentTest2(){
        System.out.println("----->Payment test 2 executed.");
    }

}
