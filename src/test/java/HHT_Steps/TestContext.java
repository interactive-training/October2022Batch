package HHT_Steps;

import HHT_Pages.AdministrationPanelPage;
import HHT_Pages.EventsPage;
import HHT_Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;

    // Pages variables
    private LoginPage loginPage;
    public EventsPage eventsPage;
    public AdministrationPanelPage administrationPanelPage;

    public TestContext(){

    }

    public WebDriver getDriver(){
        return driver;
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }


    // methods for creating a new driver or passing the previous one to the next page
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

    public EventsPage getEventsPage(){
        if(eventsPage == null){
            eventsPage = new EventsPage(driver);
        }
        return eventsPage;
    }


    //Common methods
    public String getTitle(){
        return driver.getTitle();
    }

    public String getURL(){
        return driver.getCurrentUrl();
    }




}

