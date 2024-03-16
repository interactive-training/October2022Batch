package Utilities;

import HHT_Pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestContext {
    private WebDriver driver;
    private Properties prop;
    // Page variables
    private LoginPage loginPage;
    private AdminEventsPage adminEventsPage;
    private EventsPage eventsPage;
    private AdministrationPanelPage administrationPanelPage;
    private LandingPage landingPage;
    private CalendarPage calendarPage;
    private CreateEventsPage createEventsPage;
    private EditEventsPage editEventsPage;
    private ViewEventsPage viewEventsPage;
    private DeleteEventsPage deleteEventsPage;


    // Methods for creating a new driver or passing the previous one to the next page
    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public AdministrationPanelPage getAdministrationPanelPage(){
        if(administrationPanelPage == null){
            administrationPanelPage = new AdministrationPanelPage(driver);
        }
        return administrationPanelPage;
    }

    public AdminEventsPage getAdminEventsPage(){
        if(adminEventsPage == null){
            adminEventsPage = new AdminEventsPage(driver);
        }
        return adminEventsPage;
    }
    public EventsPage getEventsPage(){
        if(eventsPage == null){
            eventsPage = new EventsPage(driver);
        }
        return eventsPage;
    }
    public LandingPage getLandingPage(){
        if(landingPage == null){
            landingPage = new LandingPage(driver);
        }
        return landingPage;
    }
    public CalendarPage getCalendarPage(){
        if(calendarPage == null){
            calendarPage = new CalendarPage(driver);
        }
        return calendarPage;
    }
    public CreateEventsPage getCreateEventsPage(){
        if(createEventsPage == null){
            createEventsPage = new CreateEventsPage(driver);
        }
        return createEventsPage;
    }
    public EditEventsPage getEditEventsPage(){
        if(editEventsPage == null){
            editEventsPage = new EditEventsPage(driver);
        }
        return editEventsPage;
    }

    public ViewEventsPage getViewEventsPage(){
        if(viewEventsPage == null){
            viewEventsPage = new ViewEventsPage(driver);
        }
        return viewEventsPage;
    }

    public DeleteEventsPage getDeleteEventsPage(){
        if(deleteEventsPage == null){
            deleteEventsPage = new DeleteEventsPage(driver);
        }
        return deleteEventsPage;
    }
    //Initialising the driver

    public WebDriver intializeDriver() throws IOException {
        // Reading Properties file
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/java/resources/config.properties");
        prop.load(fis);

        //Get browser property from config file
        String browserType = prop.getProperty("BrowserType");

        // Override from command prompt
        String browserTypeFromCommandPrompt = System.getProperty("command.browser");
        System.out.println("BrowserType from command prompt:" + System.getProperty("command.browser"));

        if (browserTypeFromCommandPrompt != null){
            browserType = browserTypeFromCommandPrompt;
        }else if (browserType.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }else if(browserType.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        }else if(browserType.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }

        // Maximise browser window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(prop.getProperty("ImpilcitTimeInSec","10"))));

        return driver;
    }

    //Common methods
    public String getTitle(){
        return driver.getTitle();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }
    public String getMessage(){
        return driver.findElement(By.xpath("//div[@class='error_msg']")).getText();
    }

    public void clickAcceptButton() throws InterruptedException {
        driver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm ms-3']")).click();
        Thread.sleep(3000);
    }


}

//@Before
//    public void setUp() throws IOException {
//       this.driver = testContext.intializeDriver();
//        System.out.println(driver.getTitle());
//    }

//    @After
//    public void teardown(){
//        this.driver.quit();
//        System.out.println("Closing browser in tearDown");
//    }