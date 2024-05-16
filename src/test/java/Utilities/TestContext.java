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

    //Pooja variables
    private PoojaDetailsPage poojaDetailsPage;
    private Poojas_AddPoojasDetailsPage poojas_addPoojasDetailsPage;
    private PoojaServicesPage poojaServicesPage;
    private Poojas_EditPoojaDetailsPage poojas_editPoojaDetailsPage;
    private SpecialPoojasPage specialPoojasPage;
    private Poojas_ViewPoojasDetails poojas_viewPoojasDetails;

    private NewsLetter_HomePage newsLetter_HomePage;
    private NewLetterConfirmationPage newsLetter_confirmationPage;

    private NewsLetterSubscriberDetailsPage newsLetterSubscriberDetailsPage;


    // Members Variables
    private MembersDetailsPage membersDetailsPage;
    private Members_ViewMembersDetailsPage members_viewMembersDetailsPage;

    private Members_DeleteMembersDetailsPage members_deleteMembersDetailsPage;


    // Methods for creating a new driver or passing the previous one to the next page

    private Admin_DonationsDetailsPage admin_donationsDetailsPage;

    private Donations_ViewDonationDetailsPage donations_viewDonationDetailsPage;

    private Donations_EditDonationsPage donationsEditDonations_Page;

    // Orders Variables
    private Admin_OrderDetailsPage admin_orderDetailsPage;
    private Orders_ViewOrderDetailsPage orders_viewOrderDetailsPage;

    //My Account Dashboard
    private MyAccountDashboardPage myAccountDashboardPage;

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
    // Calling Pooja Pages
    public PoojaDetailsPage getPoojaDetailsPage(){
        if(poojaDetailsPage == null){
            poojaDetailsPage = new PoojaDetailsPage(driver);
        }
        return poojaDetailsPage;
    }

    public Poojas_AddPoojasDetailsPage getPoojas_addPoojasDetailsPage(){
        if(poojas_addPoojasDetailsPage == null){
            poojas_addPoojasDetailsPage = new Poojas_AddPoojasDetailsPage(driver);
        }
        return poojas_addPoojasDetailsPage;
    }
    public PoojaServicesPage getPoojaServicesPage(){
        if(poojaServicesPage == null){
            poojaServicesPage = new PoojaServicesPage(driver);
        }
        return poojaServicesPage;
    }
    public Poojas_EditPoojaDetailsPage getPoojas_editPoojaDetailsPage(){
        if(poojas_editPoojaDetailsPage == null){
            poojas_editPoojaDetailsPage = new Poojas_EditPoojaDetailsPage(driver);
        }
        return poojas_editPoojaDetailsPage;
    }
    public SpecialPoojasPage getSpecialPoojasPage(){
        if(specialPoojasPage == null){
            specialPoojasPage = new SpecialPoojasPage(driver);
        }
        return specialPoojasPage;
    }
    public Poojas_ViewPoojasDetails getPoojas_viewPoojasDetails(){
        if(poojas_viewPoojasDetails == null){
            poojas_viewPoojasDetails = new Poojas_ViewPoojasDetails(driver);
        }
        return poojas_viewPoojasDetails;
    }
    public NewsLetter_HomePage getNewsLetter_homePage() {
        if (newsLetter_HomePage == null) {
            newsLetter_HomePage = new NewsLetter_HomePage(driver);
        }
        return newsLetter_HomePage;
    }
    public NewLetterConfirmationPage getNewsLetter_confirmationPage() {
        if (newsLetter_confirmationPage == null) {
            newsLetter_confirmationPage = new NewLetterConfirmationPage(driver);
        }
        return newsLetter_confirmationPage;
    }
    public NewsLetterSubscriberDetailsPage getNewsLetterSubscriberDetails_Page() {
        if (newsLetterSubscriberDetailsPage == null) {
            newsLetterSubscriberDetailsPage = new NewsLetterSubscriberDetailsPage(driver);
        }
        return newsLetterSubscriberDetailsPage;
    }
    public Admin_DonationsDetailsPage getAdmin_donationsDetails_Page() {
        if (admin_donationsDetailsPage == null) {
            admin_donationsDetailsPage = new Admin_DonationsDetailsPage(driver);
        }
        return admin_donationsDetailsPage;
    }
    public Donations_ViewDonationDetailsPage getDonations_viewDonationDetails_Page() {
        if (donations_viewDonationDetailsPage == null) {
            donations_viewDonationDetailsPage = new Donations_ViewDonationDetailsPage(driver);
        }
        return donations_viewDonationDetailsPage;
    }
    public Donations_EditDonationsPage getDonations_editDonation_Page() {
        if (donationsEditDonations_Page == null) {
            donationsEditDonations_Page = new Donations_EditDonationsPage(driver);
        }
        return donationsEditDonations_Page;
    }

    // Calling Members Page
    public MembersDetailsPage getMembersDetails_Page() {
        if (membersDetailsPage == null) {
            membersDetailsPage = new MembersDetailsPage(driver);
        }
        return membersDetailsPage;
    }
    public Members_ViewMembersDetailsPage getMembers_ViewMembersDetailsPage(){
        if (members_viewMembersDetailsPage == null) {
            members_viewMembersDetailsPage = new Members_ViewMembersDetailsPage(driver);
        }
        return members_viewMembersDetailsPage;
    }

    public Members_DeleteMembersDetailsPage getMembers_deleteMembersDetailsPage(){
        if (members_deleteMembersDetailsPage == null){
            members_deleteMembersDetailsPage = new Members_DeleteMembersDetailsPage(driver);
        }
        return members_deleteMembersDetailsPage;
    }

    // Calling Orders Page
    public Admin_OrderDetailsPage getAdmin_orderDetailsPage(){
        if(admin_orderDetailsPage == null){
            admin_orderDetailsPage = new Admin_OrderDetailsPage(driver);
        }
        return admin_orderDetailsPage;
    }

    public Orders_ViewOrderDetailsPage getOrders_viewOrderDetailsPage(){
        if(orders_viewOrderDetailsPage == null){
            orders_viewOrderDetailsPage = new Orders_ViewOrderDetailsPage(driver);
        }
        return orders_viewOrderDetailsPage;
    }

    // Calling My Account Dashboard Page

    public MyAccountDashboardPage getMyAccountDashboardPage(){
        if(myAccountDashboardPage == null){
            myAccountDashboardPage = new MyAccountDashboardPage(driver);
        }
        return myAccountDashboardPage;
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