package com.twelvego.pages;
 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
 
import java.util.List;
 
public class HeaderPage {
    private WebDriver driver;
 
    
    public HeaderPage(WebDriver driver) {
        this.driver = driver;
    }
 
    
    private List<WebElement> selectButtons() {
        return driver.findElements(By.cssSelector("[data-qa='select-button']"));
    }
 
    public WebElement getFromButton() {
        return selectButtons().get(0);
    }


public void fieldFrom(String cityName){
    WebElement fromInput = getFromButton();
    fromInput.sendKeys(cityName);
}

public void fieldTo(String cityName){
    WebElement toInput = getToButton();
    toInput.sendKeys(cityName);
}

public WebElement getToButton() {
        return selectButtons().get(1);
    }
 
public WebElement getDateFirstButton() {
        return driver.findElement(By.cssSelector("div[data-qa='datepicker-button']"));
}

public void dateFirst(String chooseDate) {
    WebElement dateFirstInput = getDateFirstButton();
        dateFirstInput.sendKeys(chooseDate);
}

public WebElement getDateSecondButton() {
        return driver.findElement(By.cssSelector("div[data-qa='datepicker-button-range']"));
}

public void dateSecond(String chooseDate) {
    WebElement dateSecondInput = getDateSecondButton();
        dateSecondInput.sendKeys(chooseDate);
}
 
    public WebElement getPeopleButton() {
        return driver.findElement(By.cssSelector("div[data-qa='people-button']"));
    }
 
    public WebElement getLogo() {
        return driver.findElement(By.cssSelector("a[data-qa='logo-component']"));
    }
 
    public WebElement getSupportLink() {
        return driver.findElement(By.cssSelector("a[href='/en/faq']"));
    }
 
    public WebElement getLanguageSelector() {
        return driver.findElement(By.cssSelector("span[data-qa='lang-selector']"));
    }
 
    public WebElement getCurrencyElement() {
        return driver.findElement(By.cssSelector("span[data-v-299b278e]"));
    }
 
    public WebElement getSearchButton() {
        return driver.findElement(By.cssSelector("button[data-qa='search-form-submit-button']"));
    }
}