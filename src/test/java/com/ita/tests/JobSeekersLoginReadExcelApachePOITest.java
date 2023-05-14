package com.ita.tests;

import com.ita.base.BaseTest;
import com.ita.pages.JobSeekersPage;
import com.ita.util.ExcelUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class JobSeekersLoginReadExcelApachePOITest extends BaseTest {

    @DataProvider
    public static Object[][] loginDetails() throws Exception {

        String excelFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\resources\\LoginDetails.xlsx";
        String excelSheetName = "Recruiter";

//        EmailID	Password	Status	ErrorMsg

        Object[][] testObjArray = ExcelUtil.getObjetArrayFromTable(excelFilePath,excelSheetName);

       return testObjArray;

    }

    @Test(dataProvider = "loginDetails")
    public void LoginTest(String EmailID, String Password, String Status, String ErrorMsg) {

//        EmailID	Password	Status	ErrorMsg
//        email@emaikl.com	mypassword	Invalid	Invalid Login Credentials.
//        invalid_email	Welcome1234	Invalid
//        invalid_email	invalid_pass	Invalid
//        email@emaikl.com		Invalid



//        System.out.println("Data from excel EmailID: " + EmailID);

        JobSeekersPage jobseekers = homepage.clickJobSeekersLinkOnTop();
        jobseekers.loginJobSeeker(EmailID, Password);

        if (Status.equalsIgnoreCase("valid")) {
            //expect the home page to appear

            Assert.assertTrue(driver.getCurrentUrl().contains("https://www.viewcvs.co.uk/dashboard.php"));

        } else if (Status.equalsIgnoreCase("Invalid")) {

            String expectedMsg = ErrorMsg;
            String actualMsg = driver.findElement(By.xpath("//div[@id='errorval']")).getText();
            Assert.assertEquals(actualMsg,expectedMsg);



        }

    }
}
