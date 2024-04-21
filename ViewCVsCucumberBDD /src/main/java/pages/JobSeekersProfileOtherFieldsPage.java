package pages;
import ita.BasePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekersProfileOtherFieldsPage extends BasePage {
    public static final Logger log = LogManager.getLogger(JobSeekersProfileOtherFieldsPage.class);
    WebDriver driver;

    public JobSeekersProfileOtherFieldsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    //Summary Field
    By clickSummary = By.xpath("//a[@href='summary.php']/img");
    By editsummary = By.name("summary");

    //  Link field
    By clickLink = By.xpath("//a[@href='links.php']/button");

    By editLinkURL = By.id("url");
    By editDescription = By.id("description");

    // Skills field
    By clickSkills = By.xpath("//a[@href='skills.php']/img");
    By enterSkill = By.id("skills");
    By selectSkillType = By.id("skilltype");

    By clickEditWorkAuthorisation = By.xpath("(//a[@href='work_authorisation.php'])[2]/img");
    By clickAddWorkAuthorisation = By.xpath("(//a[@href='work_authorisation.php'])[1]/button");
    By authorisation = By.id("country");

    By clickLanguages = By.xpath("//a[@href='languages.php']/img");
    By editLanguage = By.xpath("//select[@id='lang']");

    By editRelevanceType = By.id("reltype");

    By clickAddCertifications = By.xpath("//a[@href='certifications.php']/button");

    //By clickEditCertifications = By.xpath("//a[@href='edit_cert.php']/img");

    By editCertificationName = By.id("cname");

    By editCertificationSummary = By.id("summary");

    By yearAcquiredCertification = By.id("syear");

    By monthAcquiredCertification = By.name("smonth");

    // Assertions
    By assertSummaryPage = By.xpath("//div[text()='Edit Summary']");

    String phoneNumber;


    //Methods
    // save method if it appears in the visible window
    public void clickSaveButton() {
        By save = By.id("savechanges");
        driver.findElement(save).click();
    }

    // Click Contact Information Icon
    public void clickContact(){
        By contactBy = By.xpath("//a[@href='contact_information.php']/img");
        driver.findElement(contactBy).click();
        log.info("Contact Icon is clicked.");
    }
    // Edit Contact Information
    public void getPhone(String phoneNumber){
       By elmPhone = By.id("mobile");
        driver.findElement(elmPhone).clear();
        driver.findElement(elmPhone).sendKeys(phoneNumber);
        log.info("Phone number is entered.");
    }
    // verify Contact record through phone number
    public String getPhoneNumber(){
        String actualPhone = driver.findElement(By.xpath("//h1[text()='Contact Information']/../p/br[2]")).getText();
        log.info("Phone number is retrieved from the Profile Page.");
        return actualPhone;
    }
    public void getPhoneType(String phoneType){
        WebElement elmPhoneType = driver.findElement(By.id("phonetype"));
        Select selectObj = new Select(elmPhoneType);
        selectObj.selectByValue(phoneType);
    }
    // Click Location
    public void clickLocation(){
        By locationBy = By.xpath("//a[@href='location.php']/img");
        driver.findElement(locationBy).click();
    }

    // Edit Location
    public void getAddress1(String address1){
        By elmAddress1 = By.id("address1");
        driver.findElement(elmAddress1).clear();
        driver.findElement(elmAddress1).sendKeys(address1);
    }
    public void getAddress2(String address2){
        By elmAddress2 = By.id("address2");
        driver.findElement(elmAddress2).clear();
        driver.findElement(elmAddress2).sendKeys(address2);
    }
    public void getCountry(String country){
        By elmCountry = By.id("country");
        driver.findElement(elmCountry).clear();
        driver.findElement(elmCountry).sendKeys(country);
    }
    public void getPostcode(String postcode){
        By elmPostcode = By.id("postcode");
        driver.findElement(elmPostcode).clear();
        driver.findElement(elmPostcode).sendKeys(postcode);
    }
    public void getTown(String town){
        By elmTown = By.id("city");
        driver.findElement(elmTown).clear();
        driver.findElement(elmTown).sendKeys(town);
    }


    // Click Edit Summary Icon
    public void clickSummary() {
        driver.findElement(clickSummary).click();
    }
    //document.getElementsByClassName('add_button')[2].click();

    // Edit Summary Method
    public void editSummary(String summary) {
        driver.findElement(editsummary).clear();
        driver.findElement(editsummary).sendKeys(summary);
    }


    // Click Link Method
    public void clickLink() {
        driver.findElement(clickLink).click();
    }
    //document.getElementsByClassName('add_button')[1].click();

    //Edit Link Methods
    public void editLinkURL(String url) {
        driver.findElement(editLinkURL).sendKeys(url);
    }

    public void editLinkDescription(String descn) {
        driver.findElement(editDescription).sendKeys(descn);
    }


    // Click Skills Method
    public void clickSkills() {
        driver.findElement(clickSkills).click();
    }

    // Skills Methods
    public void setEnterSkill(String text) {
        driver.findElement(enterSkill).sendKeys(text);
    }

    public void setSkillType(String skillType) {
        WebElement elmSkill = driver.findElement(selectSkillType);
        Select selectObj = new Select(elmSkill);
        selectObj.selectByValue(skillType);
    }

    // Click Work Authorisation Edit icon
    public void clickWorkAuthorisationEdit() {
        driver.findElement(clickEditWorkAuthorisation).click();
    }

    // Edit Work Authorisation
    public void setWorkAuthorisation(String workEditAuthorisation) {
        driver.findElement(authorisation).sendKeys(workEditAuthorisation);
    }

    // Click Work Authorisation Add button
    public void clickAddWorkAuthorisation() {
        driver.findElement(clickAddWorkAuthorisation).click();
    }

    // Click Languages Edit Icon
    public void clickLanguages() {
        driver.findElement(clickLanguages).click();
    }

    //Add Languages
    public void setEditLanguage(String language) {
        WebElement elmLang = driver.findElement(editLanguage);
        Select selectobj1 = new Select(elmLang);
        selectobj1.selectByValue(language);
    }

    //Add Relevance Type
    public void setRelevanceType(String relevanceType) {
        WebElement elmRT = driver.findElement(editRelevanceType);
        Select selectobj2 = new Select(elmRT);
        selectobj2.selectByValue(relevanceType);
    }


    //Click Add Certifications Button
    public void setClickAddCertifications() {
        driver.findElement(clickAddCertifications).click();
    }


    // Add Certifications
    public void setAddCertificationName(String addCertificationName) {
        driver.findElement(editCertificationName).sendKeys(addCertificationName);
    }

    public void setAddCertificationSummary(String addCertificationSummary) {
        driver.findElement(editCertificationSummary).sendKeys(addCertificationSummary);
    }

    public void setAddYearAcquiredCertification(String certificateYear) {
        WebElement elmCYear = driver.findElement(yearAcquiredCertification);
        Select selectobj3 = new Select(elmCYear);
        selectobj3.selectByValue(certificateYear);

    }

    public void setAddMonthAcquiredCertification(String certificateMonth) {
        WebElement elmCMonth = driver.findElement(monthAcquiredCertification);
        Select selectobj3 = new Select(elmCMonth);
        selectobj3.selectByValue(certificateMonth);
    }

    // Click Awards    By.cssSelector(“input[type=\”checkbox\”][data-name=\”sampleChecklist\”]”
    //JavascriptExecutor jse = (JavascriptExecutor) driver;
    //    jse.executeScript("document.getElementById('savechanges').click();");

    public void setClickAddAwards() {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("(document.getElementsByClassName('add_button'))[4].click();");
        //By clickAddAwards = By.xpath("//h1[text()='Awards ']//../div/a/button");
        //driver.findElement(clickAddAwards);}
        // Add Award Name
    }

    public void setAddAwardName(String awardName) {
        By addAwardName = By.xpath("//input[@id='cname']");
        driver.findElement(addAwardName).sendKeys(awardName);
    }

    //Add Award Description
    public void setAddAwardDescription(String awardDescription) {
        By addAwardDescription = By.id("summary");
        driver.findElement(addAwardDescription).sendKeys(awardDescription);
    }

    //Click Extracurriculars
    public void setClickAddExtracurriculars() {
        JavascriptExecutor jsce = (JavascriptExecutor) driver;
        jsce.executeScript("(document.getElementsByClassName('add_button'))[5].click();");
    }
//    By clickAddExtracurriculars = By.xpath("//h1[text()='Extracurriculars ']//../div/a/button");
//    driver.findElement(clickAddExtracurriculars);}

    // Add Extracurriculars
    public void setAddExtracurriculars(String extracurriculars) {
        By addExtracurriculars = By.id("summary-textarea");
        driver.findElement(addExtracurriculars).sendKeys(extracurriculars);
    }

    // Click Additional Information-Relocate
    public void setClickRelocate() {
        By addRelocate = By.xpath("//a[@href='willingness_to_relocate.php']/img");
        driver.findElement(addRelocate).click();
    }

    // Add Additional Information-Relocate
//    public void setRelocate(){
//        By relocate = By.id("exampleRadios1");
//        driver.findElement(relocate).click();
//    }
    public void setRelocate() {
        By relocate = By.id("exampleRadios2");
        driver.findElement(relocate).click();
    }

    // Click Additional Information-Travel
    public void setClickTravel() {
        By addTravel = By.xpath("//a[@href='willingness_to_travel.php']/img");
        driver.findElement(addTravel).click();
    }

    public void setTravel(String inputTravel) {
        if (inputTravel.equalsIgnoreCase("Up to 100%")) {
            String[] travel = {"Up to 100%", "Up to 25%", "Up to 50%", "Up to 75%", "No travel required"};
            String travelOption;
            for (int i = 0; i < 6; i++) {
                travelOption = (travel[i]);
                switch (Integer.parseInt(travelOption)) {

                    case 0:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
                        break;
                    case 1:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
                        break;
                    case 2:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
                        break;
                    case 3:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
                        break;

                    default:
                        driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
                }
            }
        }
    }


}

//    String[] travel = {"No travel required","Up to 100%","Up to 50%","Up to 75%","Up to 25%"};
//    public void setTravel1(String travelchoice) {
//        switch(String[] travel)
//        case "No travel required":
//            driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
//        case(travel=[1]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
//        case(travel=[2]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
//        case(travel=[3]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
//        case(travel=[4]):
//        driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
//    }

//    By travel = By.id("exampleRadios2").;
//            driver.findElement(travel).click();
//
//    By travel = By.id("exampleRadios2");
//            driver.findElement(travel).click();

