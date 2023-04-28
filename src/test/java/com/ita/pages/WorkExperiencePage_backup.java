//package com.ita.pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.Select;
//
//public class WorkExperiencePage_backup extends BasePage {
//
//    WebDriver driver;
//
//    public WorkExperiencePage_backup(WebDriver driver) {
//        super(driver);
//        this.driver = driver;
//
//    }
//
//    /*
//
//       // we.AddNew(); // click ADD button
//
//    //we.AddValidExperience(); // default values will be added / all mandatroy fields -- happy flow, click 'save changes'
//
//    //we.enterCompanyName(compname)
//
//    //we.enterJobtitle(sadfas)
//
//    we.CheckUpdaetMyHeadline()
//    we.UncheckUpdateHeadLine()
//
//        we.enterCountry()
//
//     */
//
//
//    //enter company name
//        public void enterCompanyName(String compName){
//
//            driver.findElement(By.xpath("//input[@id='comp']")).sendKeys(compName);
//
//        }
//
//        public String getWorkJobTitle(String workTitle){
//            By b = By.xpath("//strong[text()='" + workTitle + "']/../..");
//
//            String s =  driver.findElement(b).getText();
//
//
//            return s;
//        }
//
//        public void select_WillingToTravel(){
//
//
//        }
//
//    public void setTravel(String inputTravel) {
//
//        if (inputTravel.equalsIgnoreCase("Up to 100%")) {
//
//            //click radio button 1
////            By b...
////            Web ..
////            click...
//
//        } else if (inputTravel.equalsIgnoreCase("")) {
//            //click radio button 2
//
//        }
//    }
//
////        String[] travel = {"Up to 100%", "Up to 25%", "Up to 50%", "Up to 75%","No travel required"};
////        String travelOption;
////        for (int i = 0; i < 6; i++) {
////            travelOption = (travel[i]);
////            switch (Integer.parseInt(travelOption)) {
////
////                case 0:
////                    driver.findElement(By.xpath("//div[@class='form-group1 rad'][2]")).click();
////                    break;
////                case 1:
////                    driver.findElement(By.xpath("//div[@class='form-group1 rad'][3]")).click();
////                    break;
////                case 2:
////                    driver.findElement(By.xpath("//div[@class='form-group1 rad'][4]")).click();
////                    break;
////                case 3:
////                    driver.findElement(By.xpath("//div[@class='form-group1 rad'][5]")).click();
////                    break;
////
////                default:
////                    driver.findElement(By.xpath("//div[@class='form-group1 rad'][1]")).click();
////            }
////        }
//
//
//        //enter job title
//        public void enterJobTitle(String jobtitle){
//
//            driver.findElement(By.xpath("//input[@id='jtitle']")).sendKeys(jobtitle);
//        }
//
//
//        public void updateHeadline(String checkAndUncheck){
//
//            if (checkAndUncheck.equalsIgnoreCase("check")){
//                driver.findElement(By.xpath("//input[@name='upd_jtitle']")).click();
//
//            }
//            else{
//                System.out.println("test");
//                //do not do anything
//            }
//
//        }
//
//        public void selectJobType(String jobType){
//
//            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='jtype']"));
//            Select selectObj = new Select(elmToSelect);
//            selectObj.selectByVisibleText(jobType);
//
//        }
//
//
//        public void selectStartMonth(String stratMonth){
//
//            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='smonth']"));
//            Select selectObj = new Select(elmToSelect);
//            selectObj.selectByValue(stratMonth);
//
//        }
//
//        public void selectStartYear(String startYear){
//            WebElement elmToSelect = driver.findElement(By.xpath("//select[@id='syear']"));
//            Select selectObj = new Select(elmToSelect);
//            selectObj.selectByValue(startYear);
//
//        }
//
////        selectEndMonth("02");
////        selectEndMonth("2014");
//
//        public void enterDescription(String desc){
//            driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys(desc);
//        }
//
//        public void clickSaveChanges(){
//
//            driver.findElement(By.xpath("//input[@id='savechanges']")).click();
//
//            //work arounds
//            //srol dow using javascript exector
//            JavascriptExecutor  jse =  (JavascriptExecutor) driver;
//            jse.executeScript("document.getElementById('savechanges').click();");
//
//
//        }
//
//
//
//}
