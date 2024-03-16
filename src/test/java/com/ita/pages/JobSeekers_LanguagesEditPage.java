package com.ita.pages;

import com.ita.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class JobSeekers_LanguagesEditPage extends BasePage {
    WebDriver driver;

    public JobSeekers_LanguagesEditPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    By editLanguage = By.id("lang");
    By editlanguageRelevanceType = By.id("reltype");

    //Add Languages
    public void setLanguage(String language) {
        WebElement elmLang = driver.findElement(editLanguage);
        Select selectobj1 = new Select(elmLang);
        selectobj1.selectByValue(language);
    }

    //Edit Relevance Type
    public void setRelevanceType(String relevanceType) {
        WebElement elmRT = driver.findElement(editlanguageRelevanceType);
        Select selectobj2 = new Select(elmRT);
        selectobj2.selectByValue(relevanceType);
    }
}

