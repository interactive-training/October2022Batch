package HomeStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class Homepage {
    WebDriver driver;
    @Given("user launch the url")
    public void userLaunchTheUrl() {
        driver = new ChromeDriver();
        driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
        System.out.println("user successfully launch the url");
    }
    @When("user clicks on Home Icon")
    public void userClicksOnHomeIcon() {
        WebElement elm1 = driver.findElement(By.xpath("(//li/a[@class='nav-link dropdown-toggle'])[1]"));
       elm1.click();
       System.out.println("Clicks on Home Icon");
    }
    @Then("Home page should refresh")
    public void homePageShouldRefresh() {
        String ExpTitle = "https://www.hanumanhindutemple.org/test_mode/index.php";
        String ActTitle = driver.getCurrentUrl();
        Assert.assertEquals(ExpTitle , ActTitle);
        System.out.println("Home page refreshed ");
         }
    @And("clicks on Accept button")
    public void clicksOnAcceptButton() {
     driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ms-3']")).click();
     System.out.println("clicks on accept button");
    }
    //Here for dropdown im using actions class
    @When("user is on About us dropdown")
    public void userIsOnAboutUsDropdown() {
        Actions actions = new Actions(driver);
       WebElement About_us = driver.findElement(By.xpath("(//li[@class='nav-item dropdown active'])[1]"));
       actions.moveToElement(About_us).perform();
       System.out.println("user at About us dropdown");
    }

    @And("user clicks on Inspirer link")
    public void userClicksOnInspirerLink() {
      driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/ul/li[1]/a")).click();
      System.out.println("Inspirer page");
    }

    @Then("should navigate to the Inspirer page")
    public void shouldNavigateToTheInspirerPage() {
        String ExpTitle = "https://www.hanumanhindutemple.org/test_mode/inspirer.php";
        String ActTitle = driver.getCurrentUrl();
        Assert.assertEquals(ExpTitle, ActTitle);
        //user at the dropdown
        Actions actions = new Actions(driver);
        WebElement About_us = driver.findElement(By.xpath("(//li[@class='nav-item dropdown active'])[1]"));
        actions.moveToElement(About_us).perform();
        System.out.println("user at About us dropdown");
    }
      @When("user clicks on Charity Hanuman Temple link")
     public void userClicksOnCharityHanumanTempleLink() {
      driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/ul/li[2]/a")).click();
      System.out.println("clicks on Charity Hanuman Temle link at about us dropdown ");
        }
        @Then("user should navigate to the  Charity Hanuman Temple")
    public void userShouldNavigateToTheCharityHanumanTemple() {
    String ExTitle = "https://www.hanumanhindutemple.org/test_mode/the_charity_hanuman_temple_uk.php";
    String AcTitle = driver.getCurrentUrl();
    Assert.assertEquals(ExTitle, AcTitle);
    System.out.println("user is on Charity Hanuman Temple page  ");
    Actions actions = new Actions(driver);
    WebElement About_us = driver.findElement(By.xpath("(//li[@class='nav-item dropdown active'])[1]"));
    actions.moveToElement(About_us).perform();
        }
    @When("user clicks on Hanuman Temple link")
    public void userClicksOnHanumanTempleLink() {
    driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/ul/li[3]/a")).click();
    System.out.println("clicks on Hanuman Temple link at dropdown");
    }

    @Then("user should navigate to the Hanuman Temple page")
    public void userShouldNavigateToTheHanumanTemplePage() {
    String Exp = "https://www.hanumanhindutemple.org/test_mode/hanuman_temple.php";
    String Act = driver.getCurrentUrl();
    Assert.assertEquals(Exp ,Act);
    System.out.println("user is on Hanuman Temple page ");
        Actions actions = new Actions(driver);
        WebElement About_us = driver.findElement(By.xpath("(//li[@class='nav-item dropdown active'])[1]"));
        actions.moveToElement(About_us).perform();
    }

    @When("user clicks on privacy palicy link")
    public void userClicksOnPrivacyPalicyLink() {
    driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[2]/ul/li[4]/a")).click();
    System.out.println("At Privacy Policy");
    }
    @Then("user should navigate to the Privacy palicy page")
    public void userShouldNavigateToThePrivacyPalicyPage() {
    String expected ="https://www.hanumanhindutemple.org/test_mode/privacy_policy.php";
    String actual = driver.getCurrentUrl();
    Assert.assertEquals(expected ,actual);
    System.out.println("Privacy Policy matched ");
    }

    @When("user clicks on news link")
    public void userClicksOnNewsLink() {
    driver.findElement(By.linkText("News")).click();
    System.out.println(" clicks on News link ");
     }

    @Then("user should navigate to the News page")
    public void userShouldNavigateToTheNewsPage() {
     String exp = "https://www.hanumanhindutemple.org/test_mode/news.php";
     String act = driver.getCurrentUrl();
     Assert.assertEquals(exp ,act);
     System.out.println("News page matched ");
    }
    @When("user clicks on Calender link at Events dropdown")
    public void userClicksOnCalenderLinkAtEventsDropdown() {
   Actions act = new Actions(driver);
   WebElement Events_dropdown = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[4]"));
   act.moveToElement(Events_dropdown).perform();
   System.out.println("At Events dropdown");
   driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[4]/ul/li[1]/a")).click();
   System.out.println("Clicks on Calender ");
    }

    @Then("user should navigate to Calender  page")
    public void userShouldNavigateToCalenderPage() {
     String Exp = "https://www.hanumanhindutemple.org/test_mode/calendar.php";
     String act = driver.getCurrentUrl();
     Assert.assertEquals(Exp ,act);
     System.out.println("Calender page matched");
        Actions Action = new Actions(driver);
        WebElement Events_dropdown = driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[4]"));
        Action.moveToElement(Events_dropdown).perform();
    }

    @And("user clicks on Events link At events dropdown")
    public void userClicksOnEventsLinkAtEventsDropdown() {
     driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[4]/ul/li[2]/a")).click();
     System.out.println("clicks on Events ");
    }

    @Then("user navigate to the Events page")
    public void userNavigateToTheEventsPage() {
     String e = "https://www.hanumanhindutemple.org/test_mode/events_web.php" ;
     String a = driver.getCurrentUrl();
     Assert.assertEquals(e ,a);
     System.out.println("Events page matched");
    }
}


