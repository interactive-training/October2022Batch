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

import java.time.Duration;
import java.util.List;

public class Crudpoojas {
    WebDriver driver;

    @Given("user launch the backend url")
    public void userLaunchTheBackendUrl() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/login.php");
        System.out.println("Admin launch the url");
    }

    @When("user enters Login details")
    public void userEntersLoginDetails() {
        driver.findElement(By.name("usr_email")).sendKeys("sk_behara@hotmail.com");
        driver.findElement(By.id("usr_password")).sendKeys("test@123");
        System.out.println("Enters login details");
    }

    @And("clicks on Login button")
    public void clicksOnLoginButton() {
        driver.findElement(By.xpath("//input[@class='btn-lg btn-success btn-block']")).click();
        System.out.println("Clicks on login button");

    }

    @Then("user should navigate to the Admin portal")
    public void userShouldNavigateToTheAdminPortal() {
        String exp = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/home.php";
        String act = driver.getCurrentUrl();
        Assert.assertEquals(exp, act);
        System.out.println("Match the Admin portal url");
    }

    @When("user is at CMS dropdown")
    public void userIsAtCMSDropdown() {
        Actions action = new Actions(driver);
        WebElement CMS_elm = driver.findElement(By.linkText("CMS"));
        action.moveToElement(CMS_elm).perform();
        System.out.println("CMS dropdown");
        driver.findElement(By.linkText("POOJAS")).click();
        System.out.println("clicked on Poojas");
    }

    @Then("user should navigate to the Add poojas page")
    public void userShouldNavigateToTheAddPoojasPage() {
        String e = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/poojas.php";
        System.out.println("match the add poojas url");
    }

    @And("user clicks on ADD pooja button")
    public void userClicksOnADDPoojaButton() {
        driver.findElement(By.partialLinkText("ADD")).click();
        System.out.println("clicks on ADd poojas");
    }

    @Then("navigate to the ADD pooja page")
    public void navigateToTheADDPoojaPage() {
        String exp = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/add_pooja.php";
        String act = driver.getCurrentUrl();
        Assert.assertEquals(exp, act);
        System.out.println("on Add poojas page ");
    }


    @When("user enters all details in all the following fields {string},{string},{string},{string}, {string} ,{string},{string},{string},{string},{string},{string}")
    public void userEntersAllDetailsInAllTheFollowingFieldsPoojaAmountIn(String PoojaTitle, String Poojaservicessection, String poojatype, String Poojastartdate, String Poojaenddate, String poojafrequency, String poojatimeduration, String poojacutofftime, String Poojaamount, String poojalocation, String poojacountry) {
        driver.findElement(By.name("title")).sendKeys(PoojaTitle);
        Actions action = new Actions(driver);
        WebElement elm = driver.findElement(By.name("pooja_categ"));
        action.moveToElement(elm).click();
        driver.findElement(By.xpath("//tr[2]/td[2]/select")).click();
        driver.findElement(By.xpath("//tr[2]/td[2]/select/./option[2]")).click();
        driver.findElement(By.name("pooja_type")).click();
        driver.findElement(By.xpath("//tr[3]/td[2]/select/option/.")).click();
        driver.findElement(By.name("strt_date")).sendKeys(Poojastartdate);
        driver.findElement(By.name("end_date")).sendKeys(Poojaenddate);
        driver.findElement(By.name("pooja_freq")).click();
        driver.findElement(By.xpath("//tr[6]/td[2]/select/./option/.")).click();
        driver.findElement(By.name("etime")).sendKeys(poojatimeduration);
        driver.findElement(By.name("pooja_cut_off")).sendKeys(poojacutofftime);
        driver.findElement(By.name("price1")).sendKeys("20");
        driver.findElement(By.name("eloc")).sendKeys(poojalocation);
        driver.findElement(By.name("country")).click();
        driver.findElement(By.xpath("//tr[11]/td[2]/select/option[224]")).click();
        System.out.println("clicked on country");
    }

    //passing info in to the iframes
    @And("Admin enters the description about festival in Pooja Artile field")
    public void adminEntersTheDescriptionAboutFestivalInPoojaArtileField() {
        WebElement outerframe = driver.findElement(By.id("article___Frame"));
        driver.switchTo().frame(outerframe);
        WebElement innerframe = driver.findElement(By.xpath("//td[@id='xEditingArea']/iframe"));
        driver.switchTo().frame(innerframe);
        driver.findElement(By.xpath("html/body")).sendKeys("Festival");
        System.out.println("iframe");
        driver.switchTo().defaultContent();
    }

    @And("clicks on Submit button")
    public void clicksOnSubmitButton() {
        driver.findElement(By.name("save")).click();
        System.out.println("clicked on submit");
    }

    //     *************** Front end ************
    @Given("Launch the frontend url")
    public void launchTheFrontendUrl() {
        driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
        System.out.println("clicked on accept button");
    }

    @When("user clicks on Poojas Icon")
    public void userClicksOnPoojasIcon() {
        driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[5]")).click();
        System.out.println("clicks on Poojas");
    }

    @Then("user navigate to the Poojas page")
    public void userNavigateToThePoojasPage() {
        String ExpUrl = "https://www.hanumanhindutemple.org/test_mode/pooja_services.php";
        String ActUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActUrl, ExpUrl);
        System.out.println(" poojas url matched");
    }

    @And("clicks on Special Poojas")
    public void clicksOnSpecialPoojas() {
        driver.findElement(By.linkText("Special Poojas")).click();
        System.out.println("Clicked on Special Poojas");
    }

    @Then("I should navigate to Special poojas page and created pooja is visible")
    public void iShouldNavigateToSpecialPoojasPage() {
        String ExpUrl = "https://www.hanumanhindutemple.org/test_mode/special_poojas.php";
        String ActUrl = driver.getCurrentUrl();
        Assert.assertEquals(ActUrl, ExpUrl);
        System.out.println("Specila poojas url matched");
    }

    //    *********** View Poojas **********
@When("I click on{string} View link")
public void iClickOnViewLink(String PoojaTitle) {
List<WebElement> ViewTitle = driver.findElements(By.xpath("//tr//td[2]"));
System.out.println(ViewTitle.size());
for (int V = 0; V <= ViewTitle.size(); V++) {
 String Title = ViewTitle.get(V).getText();
if (Title.equals(PoojaTitle)) {
 int r = V + 1;
 driver.findElement(By.xpath("//tr[" + r + "]/td[6]/a[1]")).click();
 break;
 }
 }
  }
 @Then("it should navigate to the selected poojas page")
 public void itShouldNavigateToTheSelectedPoojasPage() {
  String exp = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/pooja_view.php?j_id=66";
  String Act = driver.getCurrentUrl();
  Assert.assertEquals(exp, Act);
    }
//************ Edit Poojas ************
@When("user select the edit option for{string},and edits the{string},with{string}")
  public void editTheFollowingFields (String Poojatitle, String Editfield, String editinfo) {
  List<WebElement> EditPoojaTitle = driver.findElements(By.xpath("//tr//td[2]"));
  System.out.println(EditPoojaTitle.size());
  for (int E = 0; E < EditPoojaTitle.size(); E++) {
      String Title = EditPoojaTitle.get(E).getText();
      if (Title.equals(Poojatitle)) {
          int r1 = E + 2;
          driver.findElement(By.xpath("//tr[" + r1 + "]/td[6]/a[2]")).click();
          break;
      }
  }
    WebElement actualHeader = driver.findElement(By.xpath("//div[@id='bar']"));
    String H = actualHeader.getText();
    String expectedHeader = "Edit Pooja Details";
    Assert.assertEquals(H, expectedHeader);
    System.out.println("User is on Edit Pooja page");
   if(Editfield.equals("Pooja Title")) {
    driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();
          driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).sendKeys(editinfo);
//          driver.findElement(By.xpath("//tr[5]/td[2]/input")).clear();
//          driver.findElement(By.xpath("//tr[5]/td[2]/input")).sendKeys(editinfo);
//          driver.findElement(By.xpath("//tr[6]/td[2]/input")).clear();
//          driver.findElement(By.xpath("//tr[6]/td[2]/input")).sendKeys(editinfo);
          System.out.println("Title edited");
      }
   }
   @And("clicks on Submit button on edit page")
   public void clicksOnSubmitButtonOnEditPage() {
   driver.findElement(By.name("save")).click();
   System.out.println("Edit and submitted");
    }

    @Then("Pooja Title should be edited")
    public void poojaTitleShouldBeEdited() {
     String e ="https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/poojas.php";
     String a = driver.getCurrentUrl();
     Assert.assertEquals(e,a);
     System.out.println("Edited successfully");
    }


}







