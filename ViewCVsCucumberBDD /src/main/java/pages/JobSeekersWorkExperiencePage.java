package pages;

import io.cucumber.datatable.DataTable;
import ita.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class JobSeekersWorkExperiencePage extends BasePage {
    public static final Logger log = LogManager.getLogger(JobSeekersWorkExperiencePage.class);
    WebDriver driver;
    String title;
    Boolean checkB;

    By emailBy = By.name("email");
    By passwordBy = By.name("password");
    By button = By.xpath("//button[text()=' Sign in']");
    By workExperienceHeaderBy = By.xpath("//div[text()='Add Experience']");
    String expName,verifyJobTitle;

    By jobTitleBy = By.xpath("//strong[text()='Automation Tester']");
    By headlineBy = By.name("upd_jtitle");


    public JobSeekersWorkExperiencePage(WebDriver driver){
        super(driver);
        this.driver=driver;
    }

    public boolean isWorkExperienceHeaderTextDisplayed(){
        log.info("Going to get the Add Experience header.");
        return driver.findElement(workExperienceHeaderBy).isDisplayed();
    }


    public void setCompanyName(String name){
        By companyNameBy = By.id("comp");
        driver.findElement(companyNameBy).sendKeys(name);
        log.info("CompanyName is added.");
    }

    public void setJobTitle(String title){

        By jobTitleBy = By.cssSelector("input[name = jtitle]");
        driver.findElement(jobTitleBy).sendKeys(title);
        log.info("JobTitle is added.");
    }
    public String verifyJobTitle(){
        By jobTitleBy = By.xpath("//strong[text()='"+(title)+"']");
        String verifyJobTitle = driver.findElement(jobTitleBy).getText();
        return verifyJobTitle;
    }


    public String assertName(){
        //By expNameBy = By.xpath("//div[@class='dashboard-content-main']");
        By expNameBy = By.xpath("//a[@href='experience.php']/../../../div[13]");
        WebElement expEleName = driver.findElement(expNameBy);
        String expName = String.valueOf(expEleName.isDisplayed());
        return expName;
        //System.out.println(" Asserted the Company name");
    }

    public void setCountry(String country) throws InterruptedException {
        By countryNameBy = By.name("country");
        driver.findElement(countryNameBy).clear();
        driver.findElement(countryNameBy).sendKeys(country);
        log.info("Country is added.");
    }

    public void setTown(String town) throws InterruptedException {
        By countryNameBy = By.name("town");
        driver.findElement(countryNameBy).sendKeys(town);
    }

//    public void setUpdateHeadline(DataTable dataTable){
//
//        List<Map<String,String >> data = dataTable.asMaps();
//        String HeadlineValue = data.get(0).get("UpdateHeadline");
//
//        if (HeadlineValue == "Yes") {
//            driver.findElement(headlineBy).click();
//            System.out.println("Headline is checked.");
//        }
//
//    }
//     WebElement check = driver.findElement(headlineBy).getAttribute("value");
//
     public Boolean checkUpdateHeadline() {
        checkB = driver.findElement(headlineBy).isSelected();   // checking if it is checked/not; and storing it in check
     return checkB;}

    public void setUpdateHeadline(DataTable dataTable){
         List<Map<String,String >> data = dataTable.asMaps();
         String HeadlineValue = data.get(0).get("UpdateHeadline");  // reading value from DataTable and storing it in HeadLineValue
        String check = String.valueOf(checkB);
         if (check == "True"){
            if (HeadlineValue == "Yes") {      // if check is 'True' and DataTable is 'Yes' then do nothing
             System.out.println("Headline is checked.");

            } else if (HeadlineValue == "No") {
                driver.findElement(headlineBy).click();    // To uncheck if it is checked as the DataTable says 'No'.
             System.out.println("Headline is not checked.");
            }

       } else if (check == "False") {
           if (HeadlineValue == "Yes") {
               driver.findElement(headlineBy).click();
               System.out.println("Headline is checked.");

           } else if (HeadlineValue == "No") {
               System.out.println("Headline is not checked.");
           }
         }
     }

//    public void setUpdateHeadline(){
//        By headline = By.name("upd_jtitle");
//        driver.findElement(headline).click();
//    }

    public void setJobType(String jobType){
        WebElement elmjobType = driver.findElement(By.xpath("//div/select[@id='jtype']"));
        Select selectObj = new Select(elmjobType);
        selectObj.selectByValue(jobType);
        log.info("JobType is added.");
    }
    public void setStartMonth(String startMonth){
        WebElement elmstartMonth = driver.findElement(By.id("smonth"));
        Select selectObj = new Select(elmstartMonth);
        selectObj.selectByValue(startMonth);
        log.info("StartMonth is added.");
    }
    public void setStartYear(String startYear){
        WebElement elmStartYear = driver.findElement(By.name("syear"));
        Select selectobj = new Select(elmStartYear);
        selectobj.selectByValue(startYear);
        log.info("StartYear is added.");
    }
    public void setEndMonth(String endMonth){
        WebElement elmEndMonth = driver.findElement(By.cssSelector("#emonth")); // locating using css id
        Select selectobj = new Select(elmEndMonth);
        selectobj.selectByValue(endMonth);
        log.info("EndMonth is added.");
    }
    public void setEndYear(String endYear){
        WebElement elmEndYear = driver.findElement(By.id("eyear")); // locating using css name didn't work
        Select selectobj = new Select(elmEndYear);
        selectobj.selectByValue(endYear);
        log.info("EndYear is added.");
    }

    public void setAchievement(String achievements){
        By addachievements = By.id("achievements");
        driver.findElement(addachievements).sendKeys(achievements);
    }

    public void setDescription(String description){
        By addDescription = By.name("description");
        driver.findElement(addDescription).sendKeys(description);
    }

    public void setSaveChangesButton(){

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("document.getElementById('savechanges').click();");
        log.info("Save Button is successfully clicked.");
    }



}
