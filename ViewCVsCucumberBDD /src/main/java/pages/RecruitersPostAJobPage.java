package pages;

import ita.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RecruitersPostAJobPage extends BasePage {
    WebDriver driver;
    public RecruitersPostAJobPage(WebDriver driver){
        super(driver);
        this.driver=driver;}

    public void clickRecruitersLinkOnTop(){

        driver.findElement(By.xpath("//a[@href='recruiter_login.php']")).click();

    }

    public void clickPostAJob()  {
        driver.findElement(By.xpath("//a[@href='post_a_job.php']/button")).click();

    }
    public void setJobTitle(String jobTitle){
         By jobtitleBy = By.id("Jobtitle");
        driver.findElement(jobtitleBy).clear();
         driver.findElement(jobtitleBy).sendKeys(jobTitle);
    }
    public void setSalary(String salary){
        By salaryBy = By.id("salary");
        driver.findElement(salaryBy).clear();
        driver.findElement(salaryBy).sendKeys(salary);
    }
    public void setJobType(String jobType){
        By jobTypeBy = By.id("job_type");
        driver.findElement(jobTypeBy).clear();
        driver.findElement(jobTypeBy).sendKeys(jobType);
    }
    public void setLocation(String location){
        By locationBy = By.id("specificlocation");
        driver.findElement(locationBy).clear();
        driver.findElement(locationBy).sendKeys(location);
    }

    public void setSector(String sector){
        WebElement elmSector = driver.findElement(By.id("sector"));
        Select selectObj = new Select(elmSector);
        selectObj.selectByValue(sector);

        //log.info("JobType is added.");
    }

    public void setDescription(String location){
        By decriptionBy = By.name("jobdescription");
        driver.findElement(decriptionBy).clear();
        driver.findElement(decriptionBy).sendKeys(location);
    }

    public void clickAlert(){
        driver.switchTo().alert().accept();
    }

    public String getAlert(){
        String alertMessage =driver.switchTo().alert().getText();
        return alertMessage;
    }


}
