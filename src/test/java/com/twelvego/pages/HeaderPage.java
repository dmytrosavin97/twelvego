package com.twelvego.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
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

    public WebElement getToButton() {
        return selectButtons().get(1);
    }

    public void fieldFrom(String cityName) {
        WebElement fromInput = getFromButton();
        fromInput.sendKeys(cityName);
    }

    public void fieldTo(String cityName) {
        WebElement toInput = getToButton();
        toInput.sendKeys(cityName);
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

    public void selectDateFromCalendarPlusDays(int daysAhead) {
        driver.findElement(By.cssSelector("[data-qa='datepicker-input']")).click();

        LocalDate targetDate = LocalDate.now().plusDays(daysAhead);
        String targetDateStr = targetDate.toString();

        By dateLocator = By.cssSelector("[data-qa='day(" + targetDateStr + ")']");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(dateLocator));

        driver.findElement(dateLocator).click();
    }

    public void setAdultsCount(int desiredCount) {
        WebElement peopleButton = driver.findElement(By.cssSelector("[data-qa='people-button']"));
        peopleButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='people-adults']")));

        WebElement counter = driver.findElement(By.cssSelector("[data-qa='people-adults'] [data-qa='counter-value']"));
        int currentCount = Integer.parseInt(counter.getText());

        WebElement increaseButton = driver.findElement(By.cssSelector("[data-qa='people-adults'] [data-qa='increase-new-button']"));
        WebElement decreaseButton = driver.findElement(By.cssSelector("[data-qa='people-adults'] [data-qa='decrease-new-button']"));

        while (currentCount < desiredCount) {
            increaseButton.click();
            currentCount++;
            wait.until(ExpectedConditions.textToBePresentInElement(counter, String.valueOf(currentCount)));
        }

        while (currentCount > desiredCount && decreaseButton.isEnabled()) {
            decreaseButton.click();
            currentCount--;
            wait.until(ExpectedConditions.textToBePresentInElement(counter, String.valueOf(currentCount)));
        }
    }

    public void setChildrenCount(int desiredCount) {
        WebElement peopleButton = driver.findElement(By.cssSelector("[data-qa='people-button']"));
        peopleButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='people-children']")));

        WebElement counter = driver.findElement(By.cssSelector("[data-qa='people-children'] [data-qa='counter-value']"));
        int currentCount = Integer.parseInt(counter.getText());

        WebElement increaseButton = driver.findElement(By.cssSelector("[data-qa='people-children'] [data-qa='increase-new-button']"));
        WebElement decreaseButton = driver.findElement(By.cssSelector("[data-qa='people-children'] [data-qa='decrease-new-button']"));

        while (currentCount < desiredCount) {
            increaseButton.click();
            currentCount++;
            wait.until(ExpectedConditions.textToBePresentInElement(counter, String.valueOf(currentCount)));
        }

        while (currentCount > desiredCount && decreaseButton.isEnabled()) {
            decreaseButton.click();
            currentCount--;
            wait.until(ExpectedConditions.textToBePresentInElement(counter, String.valueOf(currentCount)));
        }
    }

    public void setInfantsCount(int desiredCount) {
    WebElement peopleButton = driver.findElement(By.cssSelector("[data-qa='people-button']"));
    peopleButton.click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='people-infants']")));

    WebElement counter = driver.findElement(By.cssSelector("[data-qa='people-infants'] [data-qa='counter-value']"));
    int currentCount = Integer.parseInt(counter.getText());

    WebElement increaseButton = driver.findElement(By.cssSelector("[data-qa='people-infants'] [data-qa='increase-new-button']"));
    WebElement decreaseButton = driver.findElement(By.cssSelector("[data-qa='people-infants'] [data-qa='decrease-new-button']"));

    while (currentCount < desiredCount) {
        increaseButton.click();
        currentCount++;
        wait.until(ExpectedConditions.textToBePresentInElement(counter, String.valueOf(currentCount)));
    }

    while (currentCount > desiredCount && decreaseButton.isEnabled()) {
        decreaseButton.click();
        currentCount--;
        wait.until(ExpectedConditions.textToBePresentInElement(counter, String.valueOf(currentCount)));
    }
    }

    
    public void selectFieldPeopleRowPlus(int i) {
        throw new UnsupportedOperationException("Unimplemented method 'selectFieldPeopleRowPlus'");
    }

    public WebElement getIncreaceNewButton() {
        throw new UnsupportedOperationException("Unimplemented method 'getIncreaceNewButton'");
    }
}
