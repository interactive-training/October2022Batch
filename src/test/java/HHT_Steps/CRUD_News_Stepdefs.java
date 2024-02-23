package HHT_Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class CRUD_News_Stepdefs {
    WebDriver driver;

    @Given("the admin user launches the url {string}")
    public void theAdminUserLaunchesTheUrlHttpsWwwHanumanhindutempleOrgTest_modeAdm_hhtMASLoginPhp(String url) {
        driver = new ChromeDriver();
        driver.get(url);
    }


    @And("logs in with Email address {string} in email field and Password {string} in password field")
    public void logsInWithEmailAddressInEmailFieldAndPasswordInPasswordField(String emailID, String password) {
        driver.findElement(By.id("usr_email")).sendKeys(emailID);
        driver.findElement(By.id("usr_password")).sendKeys(password);
        driver.findElement(By.xpath("//input[@class='btn-lg btn-success btn-block']")).click();
    }

    @And("User clicks on CMS dropdown and selects News")
    public void userClicksOnCMSDropdownAndSelectsNews() {
        WebElement cms = driver.findElement(By.linkText("CMS"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cms).perform();
        driver.findElement(By.linkText("NEWS")).click();
        driver.manage().window().maximize();

    }
    @Then("user should get News Details page")
    public void userShouldGetNewsDetailsPage() {
        String expURL = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
        String actURL = driver.getCurrentUrl();
        Assert.assertEquals(expURL,actURL);
        System.out.println("User is on News details page");
    }
//******************Creating News**********************
    @When("User clicks on Add News button")
    public void userClicksOnAddNewsButton() {
        driver.findElement(By.linkText("Add News")).click();

    }

    @Then("user should get Add News Details page")
    public void userShouldGetAddNewsDetailsPage() {
        String expectedURl = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/add_news.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURl, "Urls are same");
        System.out.println("You are on Add News Page");
    }




    @When("user enters data in all the mandatory fields {string},{string}")
    public void userEntersDataInAllTheMandatoryFields(String NewsTitle, String NewsContent) {
        WebElement NT = driver.findElement(By.name("title"));
        NT.sendKeys(NewsTitle);
        int size = driver.findElements(By.tagName("iframe")).size();
        System.out.println("the no.of iframes are:" + size);
        WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='article___Frame']"));
        driver.switchTo().frame(Frame1);
        int size1 = driver.findElements(By.tagName("iframe")).size();
        System.out.println("total frames are:" + size1);
        WebElement Frame2 = driver.findElement(By.xpath("//td[@id='xEditingArea']//iframe"));
        driver.switchTo().frame(Frame2);
        driver.findElement(By.xpath("/html/body")).sendKeys(NewsContent);
        driver.switchTo().defaultContent();
    }


    @And("clicks Submit button")
    public void clicksSubmitButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("the News should be added successfully.")
    public void theNewsShouldBeAddedSuccessfully() {
        String expectedURl = "https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURl, "Urls matched");
        System.out.println("News details Inserted successfully message should appear");
        driver.close();
    }



    @When("user launches the given url {string}")
    public void userLaunchesTheGivenUrl(String validURL) {
        driver = new ChromeDriver();
        driver.get(validURL);
        driver.manage().window().maximize();

    }

    @Then("user should be on the Home Page")
    public void userShouldBeOnTheHomePage() {
//        driver.manage().window().maximize();
        String expectedURL = "https://www.hanumanhindutemple.org/test_mode/index.php";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL, expectedURL, "User is on expected URL");
        System.out.println("homepage url verified");
    }

    @When("user clicks on News")
    public void userClicksOnNews() {
//        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//a[@class='nav-link dropdown-toggle'])[3]")).click();
        System.out.println("clicked on news");
    }
    @Then("user should be able to see the News {string}")
    public void userShouldBeAbleToSeeTheNews(String NewsTitle) {
        WebElement actualTitle = driver.findElement(By.xpath("(//div[@class='news_main'])[1]/p/a"));
        String A= actualTitle.getText();
        Assert.assertEquals(A, NewsTitle);
        System.out.println("Added News is verified.");
        driver.close();

    }
//    *******--------View the News---------************
  @When("user clicks on View of {string}")
  public void userClicksOnViewOf(String NewsTitle) {
      List<WebElement> ViewElements = driver.findElements(By.xpath("//table//tr/td[2]"));
      System.out.println(ViewElements.size());
//      driver.findElement(By.xpath("//tr[2]/td[4]/a[1]")).click();

//        if(ViewElements.contains(NewsTitle)){
//            int rows,columns;

            for (int i= 0; i<ViewElements.size(); i++) {

                String T = ViewElements.get(i).getText();

                if (T.equals(NewsTitle)) {
                    int r=i+1;
                    driver.findElement(By.xpath("//tr[" + r + "]/td[4]/a[1]")).click();
                    break;
                }
            }}

    @Then("user should get View details page")
    public void userShouldGetViewDetailsPage () {
        WebElement actualHeader = driver.findElement(By.xpath("(//div[@id='bar']/h1)"));
        String H = actualHeader.getText();
        String expectedHeader = "View News Details";
        Assert.assertEquals(H, expectedHeader);
        System.out.println("User successfully viewed News");
        driver.close();
      }
//**********-------Editing the details of News-------********
@When("user selects the Edit option for {string} and edits the {string} with {string}")
public void userSelectsTheEditOptionForAndEditsTheWith(String NewsTitle, String Editfield, String EditInfo) {
        List<WebElement> EditElements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println(EditElements.size());

        for (int i1 = 0; i1 <=EditElements.size(); i1++) {
            String Title = EditElements.get(i1).getText();

            if (Title.equals(NewsTitle)) {
                int r1 = i1+2;
                driver.findElement(By.xpath("//tr[" + r1 + "]/td[4]/a[2]")).click();
                break;
            }
        }
    WebElement actualHeader = driver.findElement(By.xpath("(//div[@id='bar'])"));
    String H = actualHeader.getText();
    String expectedHeader = "Edit News Details";
    Assert.assertEquals(H, expectedHeader);
    System.out.println("User is on Edit News page");

//    driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();

        if(Editfield.equals("News Title")){
            driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).clear();
            driver.findElement(By.xpath("((//table/tbody/tr[1]/td[2])[1]/input[@name='title'])")).sendKeys(EditInfo);
        } else if (Editfield.equals("News Artile/Content")) {
            WebElement Frame1 = driver.findElement(By.xpath("//iframe[@id='article___Frame']"));
            driver.switchTo().frame(Frame1);
            int size1 = driver.findElements(By.tagName("iframe")).size();
            System.out.println("total frames are:" + size1);
            WebElement Frame2 = driver.findElement(By.xpath("//td[@id='xEditingArea']//iframe"));
            driver.switchTo().frame(Frame2);
            driver.findElement(By.xpath("/html/body/p")).clear();
            driver.findElement(By.xpath("/html/body/p")).sendKeys(EditInfo);
            driver.switchTo().defaultContent();
        }
    }

    @And("clicks Submit button on Edit Page")
    public void clicksSubmitButtonOnEditPage() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("user should see the message {string}")
    public void userShouldSeeTheMessage(String expectedmsg) {
        String actualmsg=driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
        Assert.assertEquals(expectedmsg,actualmsg);
        System.out.println("Edited News is verified successfully");
        driver.close();
    }
//*************--------Deleting News----------*********
    @When("user clicks on Delete of {string}")
    public void userClicksOnDeleteOf(String NewsTitle) {
        List<WebElement> Elements = driver.findElements(By.xpath("//table//tr/td[2]"));
        System.out.println(Elements.size());
//     

        for (int i= 0; i<Elements.size(); i++) {

            String T = Elements.get(i).getText();

            if (T.equals(NewsTitle)) {
                int r=i+2;
                driver.findElement(By.xpath("//tr[" + r + "]/td[4]/a[3]")).click();
                break;
            }
    }
}

    @Then("user should be able delete the news")
    public void userShouldBeAbleDeleteTheNews() {
        String E="https://www.hanumanhindutemple.org/test_mode/adm_hht9m8a4s2/news.php";
        String A = driver.getCurrentUrl();
        Assert.assertEquals(A,E);
        System.out.println("News Deleted");
    }
}







