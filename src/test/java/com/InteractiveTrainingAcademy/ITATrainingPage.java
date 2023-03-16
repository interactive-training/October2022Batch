package com.InteractiveTrainingAcademy;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ITATrainingPage extends BeforeAfterMethods{

//
//    WebDriver driver;

//
//    @BeforeClass
//    public void beforeSetup(){
//
//        System.out.println("Before class executed in ITA Home page");
//
////        System.setProperty("webdriver.chrome.driver",
////                "D:\\Tools\\ChromeDriver\\chromedriver.exe");
//
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        driver = new ChromeDriver(options);
//        driver.get("https://interactivetrainingacademy.co.uk/");
//
//
//    }

    @Test
    public void verify_Manual_and_automation_page() throws InterruptedException {

        //mouse hover Training link
        WebElement elmToMouseHover = driver.findElement(By.linkText("TRAINING"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elmToMouseHover);
        actions.perform();

        WebElement elmToClick_Manual_and_Automation = driver.findElement(By.linkText("MANUAL & AUTOMATION"));
        elmToClick_Manual_and_Automation.click();

        //verify manual and automation page appears.
       WebElement elmTextManualAndAutomation =
               driver.findElement(By.xpath("//*[text()='Manual and Automation Testing']"));
        Assert.assertTrue(elmTextManualAndAutomation.isDisplayed());

//        Thread.sleep(5000);

    }


    @Test
    public void simulate_ElementNotInteractableException() throws InterruptedException {

        //click directly without seeing this element

        driver.findElement(By.xpath("//a[@title='Python']")).click();

        //Error: org.openqa.selenium.ElementNotInteractableException: element not interactable

//
//        //mouse hover Training link
//        WebElement elmToMouseHover = driver.findElement(By.linkText("TRAINING"));
//
//        Actions actions = new Actions(driver);
//        actions.moveToElement(elmToMouseHover);
//        actions.perform();
//
//        WebElement elmSubMenu = driver.findElement(By.linkText("PYTHON"));
//        elmSubMenu.click();

//        Thread.sleep(5000);

    }

    @Test
    public void verify_Python_Page() throws InterruptedException {

        //mouse hover Training link
        WebElement elmToMouseHover = driver.findElement(By.linkText("TRAINING"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elmToMouseHover);
        actions.perform();

        WebElement elmSubMenu = driver.findElement(By.linkText("PYTHON"));
        elmSubMenu.click();

        //verify manual and automation page appears.
        WebElement elmTextToVerify =
                driver.findElement(By.xpath("//h2/*[text()='Python']"));
        Assert.assertTrue(elmTextToVerify.isDisplayed());

        Thread.sleep(1000);

    }

    @Test
    public void verify_Devops_page() throws InterruptedException {

        //mouse hover Training link
        WebElement elmToMouseHover = driver.findElement(By.linkText("TRAINING"));

        Actions actions = new Actions(driver);
        actions.moveToElement(elmToMouseHover);
        actions.perform();

        WebElement elmToClick_Manual_and_Automation = driver.findElement(By.linkText("DEVOPS"));
        elmToClick_Manual_and_Automation.click();

        //verify manual and automation page appears.
        WebElement elmTextManualAndAutomation =
                driver.findElement(By.xpath("//*[text()='DevOps']"));
        Assert.assertTrue(elmTextManualAndAutomation.isDisplayed());

//        Thread.sleep(5000);

    }

    @Test
    public void newTest(){
        System.out.println("New test added");
    }
//    @AfterClass
//    public void tearDown(){
//        System.out.println("After test executed in ITA Training Page");
//
//        driver.quit();
//    }

}
