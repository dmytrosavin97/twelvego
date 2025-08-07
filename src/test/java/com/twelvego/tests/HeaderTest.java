package com.twelvego.tests;

import com.twelvego.config.BaseTest;
import com.twelvego.pages.HeaderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HeaderTest extends BaseTest {

    private HeaderPage headerPage;
    private WebDriverWait wait;

    @BeforeEach
    void initPage() {
        headerPage = new HeaderPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void testFromFieldIsClickable() {
        WebElement from = headerPage.getFromButton();
        assertTrue(from.isDisplayed(), "Поле From должно отображаться");
        from.click();
    }

    @Test
    public void testToFieldIsClickable() {
        WebElement to = headerPage.getToButton();
        assertTrue(to.isDisplayed(), "Поле To должно отображаться");
        to.click();
    }

    @Test
    public void testDatepickerButtonIsClickable() {
        WebElement dateButton = headerPage.getDateFirstButton();
        assertTrue(dateButton.isDisplayed(), "Кнопка первой даты должна отображаться");

        dateButton.click();
        headerPage.selectDateFromCalendarPlusDays(4);
    }

    @Test
    public void testDatepickerRangeButtonIsClickable() {
        WebElement dateRangeButton = headerPage.getDateSecondButton();
        assertTrue(dateRangeButton.isDisplayed(), "Кнопка второй даты должна отображаться");

        dateRangeButton.click();
        headerPage.selectDateFromCalendarPlusDays(6);
    }

    @Test
    public void testPeopleButtonIsClickable() {
        WebElement people = headerPage.getPeopleButton();
        assertTrue(people.isDisplayed(), "Кнопка выбора количества пассажиров должна отображаться");

        people.click();
    }

    @Test
    public void testLogoIsDisplayed() {
        assertTrue(headerPage.getLogo().isDisplayed(), "Логотип должен отображаться");
    }

    @Test
    public void testSupportLinkIsClickable() {
        WebElement support = headerPage.getSupportLink();
        assertTrue(support.isDisplayed(), "Ссылка на поддержку должна отображаться");

        support.click();
    }

    @Test
    public void testLanguageSelectorIsClickable() {
        WebElement lang = headerPage.getLanguageSelector();
        assertTrue(lang.isDisplayed(), "Переключатель языка должен отображаться");

        lang.click();
    }

    @Test
    public void testCurrencySelectorIsDisplayed() {
       
        WebElement currency = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("span[data-v-299b278e]")));
        assertTrue(currency.isDisplayed(), "Выбор валюты должен отображаться");
    }

    @Test
    public void testFindTicketsButtonIsClickable() {
        WebElement search = headerPage.getSearchButton();
        assertTrue(search.isDisplayed(), "Кнопка поиска билетов должна отображаться");

        search.click();
    }
    @Test
public void testInfantsBlockIsDisplayed() {
    headerPage.getPeopleButton().click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement infantsBlock = wait.until(
        ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='people-infants']"))
    );

    assertTrue(infantsBlock.isDisplayed(), "Блок Infants отображается");
}

}
