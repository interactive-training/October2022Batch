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
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class TestContext {
    private WebDriver driver;
    public Map<Long, WebDriver> webDriverObjects = new HashMap<>();
    private Properties prop;
    // Front-end Page variables
    private LoginPage loginPage;
    private EventsPage eventsPage;
    private LandingPage landingPage;
    private CalendarPage calendarPage;
    private NewsPage newsPage;
    private CommonMethods commonMethods;
    private MyAccountPage myAccountPage;

    // Admin Event variables
    private AdministrationPanelPage administrationPanelPage;
    private AdminEventsPage adminEventsPage;
    private CreateEventsPage createEventsPage;
    private EditEventsPage editEventsPage;
    private ViewEventsPage viewEventsPage;
    private DeleteEventsPage deleteEventsPage;

// Admin News variables
    private NewsDetailsPage newsDetailsPage;
    private News_AddNewsDetailsPage news_addNewsDetailsPage;
    private News_ViewNewsDetailsPage news_viewNewsDetailsPage;
    private News_EditNewsDetailsPage news_editNewsDetailsPage;

// Payment variables
    private DonationsPage donationsPage;
    private DonationsDetailsPage donationsDetailsPage;
    private DonationsProductDetailsPage donationsProductDetailsPage;
    private ShoppingCartPage shoppingCartPage;
    private PaymentPage paymentPage;
    private OrderConfirmationPage orderConfirmationPage;

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
    public MyAccountPage getMyAccountPage() {
        if (myAccountPage == null) {
            myAccountPage = new MyAccountPage(driver);
        }
        return myAccountPage;
    }
    public EventsPage getEventsPage(){
        if(eventsPage == null){
            eventsPage = new EventsPage(driver);
        }
        return eventsPage;
    }
    public NewsPage getNewsPage(){
        if(newsPage == null){
            newsPage = new NewsPage(driver);
        }
        return newsPage;
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
    public CommonMethods getCommonMethods(){
        if(commonMethods == null){
            commonMethods = new CommonMethods(driver);
        }
        return commonMethods;
    }
    //Calling Event Pages
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
    // Calling News Pages
    public NewsDetailsPage getNewsDetailsPage(){
        if(newsDetailsPage == null){
            newsDetailsPage = new NewsDetailsPage(driver);
        }
        return newsDetailsPage;
    }

    public News_AddNewsDetailsPage getNews_addNewsDetailsPage(){
        if(news_addNewsDetailsPage == null){
            news_addNewsDetailsPage = new News_AddNewsDetailsPage(driver);
        }
        return news_addNewsDetailsPage;
    }
    public News_ViewNewsDetailsPage getNews_viewNewsDetailsPage(){
        if(news_viewNewsDetailsPage == null){
            news_viewNewsDetailsPage = new News_ViewNewsDetailsPage(driver);
        }
        return news_viewNewsDetailsPage;
    }
    public News_EditNewsDetailsPage getNews_editNewsDetailsPage(){
        if(news_editNewsDetailsPage == null){
            news_editNewsDetailsPage = new News_EditNewsDetailsPage(driver);
        }
        return news_editNewsDetailsPage;
    }
    // Calling Payment Pages
    public DonationsPage getDonationsPage(){
        if(donationsPage == null){
            donationsPage = new DonationsPage(driver);
        }
        return donationsPage;
    }
    public DonationsDetailsPage getDonationsDetailsPage(){
        if(donationsDetailsPage == null){
            donationsDetailsPage = new DonationsDetailsPage(driver);
        }
        return donationsDetailsPage;
    }
    public DonationsProductDetailsPage getDonationsProductDetailsPage(){
        if(donationsProductDetailsPage == null){
            donationsProductDetailsPage = new DonationsProductDetailsPage(driver);
        }
        return donationsProductDetailsPage;
    }
    public ShoppingCartPage getShoppingCartPage(){
        if(shoppingCartPage == null){
            shoppingCartPage = new ShoppingCartPage(driver);
        }
        return shoppingCartPage;
    }
    public PaymentPage getPaymentPage(){
        if(paymentPage == null){
            paymentPage = new PaymentPage(driver);
        }
        return paymentPage;
    }
    public OrderConfirmationPage getOrderConfirmationPage(){
        if(orderConfirmationPage == null){
            orderConfirmationPage = new OrderConfirmationPage(driver);
        }
        return orderConfirmationPage;
    }

    //Initialising the driver
    public WebDriver getDriver() throws IOException {
        if (driver == null) {
            WebDriver d = intializeDriver();
            webDriverObjects.put(Thread.currentThread().getId(), d);
            System.out.println("Thread id:"+ Thread.currentThread().getId());
            return webDriverObjects.get(Thread.currentThread().getId());

        } else
            System.out.println("Thread id:"+ Thread.currentThread().getId());
            return webDriverObjects.get(Thread.currentThread().getId());
    }
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