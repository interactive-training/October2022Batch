package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JobSeekersPageTest extends BaseTest {

//    WebDriver driver;

    @Test(priority = 0, description = "Test description goes here to display in the report left side of the IDE.")
    public void verifyJObSeekers(){

        JobSeekersPage jobseekers = homepage.clickJobSeekersLinkOnTop();
        jobseekers.loginJobSeeker("chamtester23@gmail.com", "Welcome@123");

        jobseekers.addWorkExperience();

        //verify work experience page appeared
        Assert.assertTrue(jobseekers.isWorkExperienceHeaderTextDisplayed(), "Work experience page does not loaded property.");


//
////        didn't work with xpath
//        driver.findElement(By.xpath("(//button[@class='add_button'])[1]")).click();
//        driver.findElement(By.xpath("(//div[@class='edcl'])[10]/a/button")).click();
//        driver.findElement(By.xpath("//a[@href='experience.php']/button[text()='ADD']")).click();
//        driver.findElement(By.xpath("//a[@href='experience.php']/button")).click();

        //selector's hub relative xpath didn't work
        //driver.findElement(By.xpath("//a[@href='experience.php']//button[@class='add_button'][normalize-space()='ADD']")).click();
        //WebElement workExperienceAddButton= driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div[2]/div[9]/div[1]/a[1]/button[1]"));
        //WebElement workExperienceAddButton = driver.findElement(By.xpath("//a[@href='experience.php']//button[@class='add_button']"));
        //workExperienceAddButton.click();
        //driver.findElement(By.cssSelector("body > div:nth-child(1) > div:nth-child(8) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(9) > div:nth-child(1) > a:nth-child(1) > button:nth-child(1)")).click();

//        driver.findElement(By.cssSelector("a[href=experience.php]/button")).click();
    }
}
