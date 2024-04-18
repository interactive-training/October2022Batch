package HomeStep;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class MyAccount {
        WebDriver driver;
        @When("launch the url")
        public void launchTheUrl() {
            driver = new ChromeDriver();
            driver.get("https://www.hanumanhindutemple.org/test_mode/index.php");
            System.out.println("Hanuman Hindu Temple Home page");
        }
        @When("user  clicks on My Account link on Home page")
        public void userClicksOnMyAccountLinkOnHomePage() {
            driver.findElement(By.linkText("My Account")).click();
            System.out.println("clicked on My Account");
        }

        @And("entered all the existing account details")
        public void enteredAllTheExistingAccountDetails() {
            driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("d@gmail.com");
            driver.findElement(By.xpath("//input[@id='pwd']")).sendKeys("012");
            driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
            System.out.println("details entered");
        }
        @Then("user should navigate to the My Account Dashboard")
        public void userShouldNavigateToTheMyAccountDashboard() {
            String Eurl = "https://www.hanumanhindutemple.org/test_mode/dashboard.php?eid=20";
            String Aurl = driver.getCurrentUrl();
            Assert.assertEquals(Aurl ,Eurl);
        }
        @And("clicks on My Account Icon")
        public void clicksOnMyAccountIcon() {
            driver.manage().window().maximize();
            driver.findElement(By.xpath("(//div[@class='col-md-4 col-sm-12 col-xs-12'])[1]")).click();
            System.out.println("My Account Icon clicks");
        }

        @Then("user navigate to My Account page")
        public void userNavigateToMyAccountPage() {
            String Eurl = "https://www.hanumanhindutemple.org/test_mode/dashboard.php";
            String Aurl = driver.getCurrentUrl();
            Assert.assertEquals(Aurl ,Eurl);
            System.out.println("My Account Icon page ");
        }
        // Here Once I click on family member and unabe to return to the My Account dashboard //
        //Having an issue with locating my account link
        @When("user clicks on Family Members Icon")
        public void userClicksOnFamilyMembersIcon() {
            driver.findElement(By.xpath("(//div[@class='col-md-4 col-sm-12 col-xs-12'])[2]")).click();
        }
        @Then("user naviagate to Family Members page")
        public void userNaviagateToFamilyMembersPage() {
            String Expurl = "https://www.hanumanhindutemple.org/test_mode/family_members_donors.php";
            String Acturl = driver.getCurrentUrl();
            Assert.assertEquals(Acturl ,Expurl);
            System.out.println("Famlily Member Icon page ");
        }
        @And("user Clicks on My Acccount")
        public void userClicksOnMyAcccount() throws InterruptedException {
//       Actions actions = new Actions(driver);
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("document.getElementsByName('My Account').click();");
            Thread.sleep(3000);
            driver.findElement(By.xpath("(//li/a[@class='btn btn-primary'])[1]")).click();
            //  actions.moveToElement(Elm_MyAcc).click();
            System.out.println("clicked on My Account");
        }
        @Then("user should receive Dasboard page")
        public void userShouldReceiveDasboardPage() {
            String Exptitle = "https://www.hanumanhindutemple.org/test_mode/dashboard.php";
            String Acttitle = driver.getCurrentUrl();
            Assert.assertEquals(Acttitle ,Exptitle);
            System.out.println(" Dashboard ");
        }
        // from here it is working fine
        @When("user clicks on Calender Icon")
        public void userClicksOnCalenderIcon() {
            driver.findElement(By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[3]")).click();
            System.out.println("clicks on Calender");
        }

        @Then("user navigate to Calender page")
        public void userNavigateToCalenderPage() {
            String Exp = "https://www.hanumanhindutemple.org/test_mode/m_calendar.php";
            String Act = driver.getCurrentUrl();
            Assert.assertEquals(Act , Exp);
            System.out.println("user is on Calenders page");
        }

        @And("user clicks on My Account link")
        public void userClicksOnMyAccountLink() {
            driver.findElement(By.xpath("//li/a[@class='active-menu']")).click();
            System.out.println("clicked on My Account on Calenders page");

        }

        @Then("user comebacks to the Dasboard page")
        public void userComebacksToTheDasboardPage() {
            String Expcted = "https://www.hanumanhindutemple.org/test_mode/dashboard.php";
            String Actual = driver.getCurrentUrl();
            Assert.assertEquals(Expcted , Actual);
        }

        @When("user clicks on Events Icon")
        public void userClicksOnEventsIcon() {
            driver.findElement(By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[4]")).click();
            System.out.println("clicks on Events");
        }

        @Then("user naviagate to the Events page")
        public void userNaviagateToTheEventsPage() {
            String Eurl = "https://www.hanumanhindutemple.org/test_mode/m_events.php";
            String Aurl = driver.getCurrentUrl();
            Assert.assertEquals(Aurl ,Eurl);
            System.out.println("on Events page ");
        }

        @And("clicks on My Account link button")
        public void clicksOnMyAccountLinkButton() {
            driver.findElement(By.xpath("//li/a[@class='active-menu']")).click();
            System.out.println("clicks on myaccount on events page ");
        }
        @Then("user comes back to the Dshboard page")
        public void userComesBackToTheDshboardPage() {
            String expUrl = "https://www.hanumanhindutemple.org/test_mode/dashboard.php";
            String actUrl = driver.getCurrentUrl();
            Assert.assertEquals(actUrl,expUrl);
            System.out.println("user returns to myaccount");
        }

        @When("user clicks on Poojas Icon")
        public void userClicksOnPoojasIcon() {
            driver.findElement(By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[5]")).click();
            System.out.println("clicks on Poojas");
        }

        @Then("user navigate to the Poojas page")
        public void userNavigateToThePoojasPage() {
            String ExpUrl = "https://www.hanumanhindutemple.org/test_mode/m_pooja_services.php";
            String ActUrl = driver.getCurrentUrl();
            Assert.assertEquals(ActUrl,ExpUrl);
        }
        @And("clicks on My Account Link txt")
        public void clicksOnMyAccountLinkTxt() {
            driver.findElement(By.xpath("//li/a[@class='active-menu']")).click();
            System.out.println("clicks my account on poojas page ");
        }

        @When("user clicks on Donations link")
        public void userClicksOnDonationsLink() {
            driver.findElement(By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[6]")).click();
            System.out.println("clicks on donations ");
        }

        @Then("user should navigate to the Donations page")
        public void userShouldNavigateToTheDonationsPage() {
            String EpUrl = "https://www.hanumanhindutemple.org/test_mode/m_donations.php";
            String AtUrl = driver.getCurrentUrl();
            Assert.assertEquals(AtUrl,EpUrl);

        }

        @And("clicks on My account link on Dashboard")
        public void clicksOnMyAccountLinkOnDashboard() {
            driver.findElement(By.xpath("//li/a[@class='active-menu']")).click();
            System.out.println("clicks on my account on donations page ");
        }

        @When("user clicks on Logout button")
        public void userClicksOnLogoutButton() {
            driver.findElement(By.linkText("Logout")).click();
            System.out.println("clicks on Logout");
        }

        @Then("user should naviagte to My Account existing member page")
        public void userShouldNaviagteToMyAccountExistingMemberPage() {
            String EpUrl = "https://www.hanumanhindutemple.org/test_mode/account_login.php";
            String AtUrl = driver.getCurrentUrl();
            Assert.assertEquals(AtUrl,EpUrl);
            System.out.println("user is on my account existing memeber page");
        }

    }


