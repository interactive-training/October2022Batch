import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountpage {
    // public static final Logger log = LogManager.getLogger(CreateSpecialPoojasPage.class.getName());
    WebDriver driver;

    public MyAccountpage(WebDriver driver) {
        this.driver = driver;
    }

    By ByMyAccountlink = By.linkText("My Account");
    By ByUsername = By.xpath("(//input[@id='email'])[2]");
    By ByPassword = By.xpath("//input[@id='pwd']");
    By ByLoginButton = By.xpath("(//button[@class='btn btn-primary'])[1]");
    By MyAccountIcon = By.xpath("(//div[@class='col-md-4 col-sm-12 col-xs-12'])[1]");
    By FamilyMembersIcon = By.xpath("(//div[@class='col-md-4 col-sm-12 col-xs-12'])[2]");
    By CalenderIcon = By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[3]");
    By EventsIcon = By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[4]");
    By PoojasIcon = By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[5]");
    By DonationsIcon = By.xpath("(//div[@class='panel panel-primary text-center no-boder blue'])[6]");
    By LogoutButton = By.linkText("Logout");
}
