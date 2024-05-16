package HHT_Pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MyAccountDashboardPage {
    public static final Logger log = LogManager.getLogger(News_ViewNewsDetailsPage.class.getName());
    WebDriver driver;

    // By Variables
    By FamilyMembersDonorsBy = By.xpath("//ul[@id='main-menu']//li[2]//a");
    By CalendarHeaderBy = By.xpath("(//a[@href='m_calendar.php'])[3]");

    By EventsHeaderBy = By.xpath("(//a[@href='m_events.php'])[3]");

    By PoojasHeaderBy = By.xpath("(//a[@href='m_pooja_services.php'])[3]");

    By DonationsHeaderBy = By.xpath("(//a[@href='m_donations.php'])[3]");

    By LogoutHeaderBy = By.linkText("Logout");

    public MyAccountDashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public void verifyDashboard(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Titles have matched.");

    }
    public void verifyFamilyMembersDonorsHeader(){
        WebElement familyMembersDonors = driver.findElement(FamilyMembersDonorsBy);
        familyMembersDonors.click();
    }
    public void verifyFamilyMembersDonors(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");

    }
    public void verifyCalendarHeader()
    {
        WebElement calendarHeader =  driver.findElement(CalendarHeaderBy);
        calendarHeader.click();

    }
    public void verifyCalendar(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }

    public void verifyEventsHeader(){
        WebElement eventsHeader =  driver.findElement(EventsHeaderBy);
        eventsHeader.click();
    }
    public void verifyEvents(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }
    public void verifyPoojasHeader(){
        WebElement poojasHeader = driver.findElement(PoojasHeaderBy);
        poojasHeader.click();
    }
    public void verifyPoojas(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }
    public void verifyDonationsHeader(){
        WebElement donationsHeader =  driver.findElement(DonationsHeaderBy);
        donationsHeader.click();
    }
    public void verifyDonations(String expectedTitle){
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Titles have matched.");
    }
    public void verifyLogout(){
        WebElement logoutHeader =  driver.findElement(LogoutHeaderBy);
        logoutHeader.click();
    }

}
