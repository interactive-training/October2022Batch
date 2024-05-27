package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class MyAccountDashboardPage {
    public static final Logger log = LogManager.getLogger(News_ViewNewsDetailsPage.class.getName());
    WebDriver driver;
    WebDriver wait;

    // By Variables
    By FamilyMembersDonorsBy = By.xpath("//ul[@id='main-menu']//li[2]//a");
    By CalendarHeaderBy = By.xpath("(//a[@href='m_calendar.php'])[3]");

    By EventsHeaderBy = By.xpath("(//a[@href='m_events.php'])[3]");

    By PoojasHeaderBy = By.xpath("(//a[@href='m_pooja_services.php'])[3]");

    By DonationsHeaderBy = By.xpath("(//a[@href='m_donations.php'])[3]");

    By LogoutHeaderBy = By.linkText("Logout");

    By header1By = By.xpath("//h2");
    By header2By = By.xpath("//h1");


    public MyAccountDashboardPage(WebDriver driver){
        this.driver = driver;
        this.wait = driver;
    }

    public void verifyDashboard(String expectedTitle){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FamilyMembersDonorsBy));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Titles have not matched.");

    }
    public void verifyFamilyMembersDonorsHeader(){
        WebElement familyMembersDonors = driver.findElement(FamilyMembersDonorsBy);
        familyMembersDonors.click();
    }
    public void verifyFamilyMembersDonors(String expectedTitle){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(header1By));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");

    }
    public void verifyCalendarHeader()
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalendarHeaderBy)).click();
//        WebElement calendarHeader =  driver.findElement(CalendarHeaderBy);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
//        calendarHeader.click();

    }
    public void verifyCalendar(String expectedTitle){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(header1By));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }

    public void verifyEventsHeader(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(EventsHeaderBy)).click();
//        WebElement eventsHeader =  driver.findElement(EventsHeaderBy);
//        eventsHeader.click();
    }
    public void verifyEvents(String expectedTitle){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(header2By));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }
    public void verifyPoojasHeader(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement poojasHeader = driver.findElement(PoojasHeaderBy);
        poojasHeader.click();
    }
    public void verifyPoojas(String expectedTitle){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(header1By));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }
    public void verifyDonationsHeader(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(DonationsHeaderBy)).click();
//        WebElement donationsHeader =  driver.findElement(DonationsHeaderBy);
//        donationsHeader.click();
    }
    public void verifyDonations(String expectedTitle){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(header1By));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have not matched.");
    }
    public void verifyLogout(){
        WebElement logoutHeader =  driver.findElement(LogoutHeaderBy);
        logoutHeader.click();
    }

}
