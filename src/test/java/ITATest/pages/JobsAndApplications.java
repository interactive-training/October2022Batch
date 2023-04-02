package ITATest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class JobsAndApplications {

    WebDriver driver;


    By jobsAndApplicationsLink = By.linkText("Jobs & applications");
    By manageJobsTextBy = By.xpath("//div[text()='Manage Jobs ']");

    public JobsAndApplications(WebDriver driver){
        this.driver = driver;

    }

    public void clickJobsAndApplicationMainMenu(){
        //jobs and verification link

        driver.findElement(jobsAndApplicationsLink).click();

    }

    public String getManageJobsText(){
        return  driver.findElement(manageJobsTextBy).getText().trim();
    }


}
