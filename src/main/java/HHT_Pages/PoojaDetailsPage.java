package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class PoojaDetailsPage {
    public static final Logger log = LogManager.getLogger(PoojaDetailsPage.class.getName());
    WebDriver driver;

    // Constructor
    public PoojaDetailsPage(WebDriver driver){
        this.driver = driver;
    }
// By variables

    public Boolean verifyAddPoojaDetailsHeader(){
        return driver.findElement(By.xpath("//div[@id='bar']/h1")).isDisplayed();
    }

    public void clickAddPoojaButton(){
        driver.findElement(By.partialLinkText("ADD")).click();
    }

    public void clickViewOption(String PoojaTitle){
        List<WebElement> titleElements = driver.findElements(By.xpath("//tr/td[2]"));
        System.out.println(titleElements.size());
        log.info("Number of Event Elements to view: " + titleElements.size());


        for (int n = 0; n < titleElements.size(); n++) {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // Looping each Event Title
            String title = titleElements.get(n).getText();

            if (title.equalsIgnoreCase(PoojaTitle)) {
//        List<WebElement> ViewTitle = driver.findElements(By.xpath("//tbody/tr/td[2]"));
//        System.out.println(ViewTitle.size());
//        log.info("Number of Pooja Titles for View:" + ViewTitle.size());
//
//        for (int X = 0; X<ViewTitle.size(); X++) {
//            String Title = ViewTitle.get(X).getText();
//            if (Title.equals(PoojaTitle)) {
                int r = n + 2;
                driver.findElement(By.xpath("//tr[" + r + "]/td[6]/a[1]")).click();
                System.out.println("Clicked View for the title:"+ PoojaTitle);
                break;
            }
        }
    }
    public void clickEditPoojaOption(String PoojaTitle){
        List<WebElement> EditTitle = driver.findElements(By.xpath("//tr//td[2]"));
        System.out.println(EditTitle.size());
        for (int X = 0; X<EditTitle.size(); X++) {
            String Title = EditTitle.get(X).getText();
            if (Title.equals(PoojaTitle)) {
                int r = X + 2;
                driver.findElement(By.xpath("//tr[" + r + "]/td[6]/a[2]")).click();
                System.out.println("Clicked Edit for the title:"+ PoojaTitle);
                break;
            }
        }
    }

    public void clickDeletePoojaOption(String PoojaTitle){

        List<WebElement> DeleteTitle = driver.findElements(By.xpath("//tr//td[2]"));

        System.out.println(DeleteTitle.size());
        log.info("Number of Pooja Titles for Deletion:" + DeleteTitle.size());

        for (int X = 0; X<DeleteTitle.size(); X++) {
            String Title = DeleteTitle.get(X).getText();
            if (Title.equals(PoojaTitle)) {
                int r = X + 2;
                driver.findElement(By.xpath("//tr[" + r + "]/td[6]/a[3]")).click();
                System.out.println("Clicked Delete for the title:"+ PoojaTitle);
                break;
            }
        }
    }
    public String verifyPoojaDetailsUpdatedMessage(){
        return driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
    }




}
