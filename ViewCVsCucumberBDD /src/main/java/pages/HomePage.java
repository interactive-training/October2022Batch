package pages;
import ita.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
   WebDriver driver;
   By jobseekersBy = By.linkText("Job Seekers");

   public HomePage(WebDriver driver){
      super(driver);
      this.driver =driver;
   }

   public JobSeekersLoginPage clickJobSeekersLinkOnTop(){
      driver.findElement(jobseekersBy).click();
      return new JobSeekersLoginPage(driver);
   }

   public void OpenURL(){
      driver.get("https://www.viewcvs.co.uk");
   }

   public void setSaveNextButton(){
      driver.findElement(By.xpath("//input[@id='next']")).click();
   }



//   public void wait(){
//      String wait = prop.getProperty("ImplicitTimeInSec");
//   }
}
