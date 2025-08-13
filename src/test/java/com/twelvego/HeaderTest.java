package com.twelvego;

import com.twelvego.config.BaseTest;
import com.twelvego.pages.HeaderPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import io.qameta.allure.junit5.AllureJunit5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(AllureJunit5.class)

@Epic("Хедер сайта")
@Feature("Поля поиска и выбора даты")

public class HeaderTest extends BaseTest {

    private HeaderPage headerPage;
    private WebDriverWait wait;

    @BeforeEach
    void initPage() {
        headerPage = new HeaderPage(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }
     

    @Test
    
    @Story("Поле 'From'")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поле 'From' кликабельно")

    public void testFromFieldIsClickable() {
        WebElement from = headerPage.getFromButton();
        assertTrue(from.isDisplayed(), "Поле From должно отображаться");
        from.click();
    }

    // @Test

    
    // @Story("Поле 'To'")
    // @Severity(SeverityLevel.NORMAL)
    // @DisplayName("Поле 'To' кликабельно")

    // public void testToFieldIsClickable() {
    //     WebElement to = headerPage.getToButton();
    //     assertTrue(to.isDisplayed(), "Поле To должно отображаться");
    //     to.click();
    // }

    @Test

    
    @Story("Поле 'DatepickerButton'")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Поле 'DatepickerButton' кликабельно")

    public void testDatepickerButtonIsClickable() {
        WebElement dateButton = headerPage.getDateFirstButton();
        assertTrue(dateButton.isDisplayed(), "Кнопка первой даты должна отображаться");

        dateButton.click();
        headerPage.selectDateFromCalendarPlusDays(4);
    }

    // @Test

    // @Story("Поле 'DatepickerRangeButton'")
    // @Severity(SeverityLevel.NORMAL)
    // @DisplayName("Поле 'DatepickerRangeButton' кликабельно")

    // public void testDatepickerRangeButtonIsClickable() {
    //     WebElement dateRangeButton = headerPage.getDateSecondButton();
    //     assertTrue(dateRangeButton.isDisplayed(), "Кнопка второй даты должна отображаться");

    //     dateRangeButton.click();
    //     headerPage.selectDateFromCalendarPlusDays(6);
    // }

    // @Test
    // public void testPeopleButtonIsClickable() {
    //     WebElement people = headerPage.getPeopleButton();
    //     assertTrue(people.isDisplayed(), "Кнопка выбора количества пассажиров должна отображаться");

    //     people.click();
    // }

    @Test
    public void testLogoIsDisplayed() {
        assertTrue(headerPage.getLogo().isDisplayed(), "Логотип должен отображаться");
    }

    // @Test
    // public void testSupportLinkIsClickable() {
    //     WebElement support = headerPage.getSupportLink();
    //     assertTrue(support.isDisplayed(), "Ссылка на поддержку должна отображаться");

    //     support.click();
    // }

//     @Test
//     public void testLanguageSelectorIsClickable() {
//         WebElement lang = headerPage.getLanguageSelector();
//         assertTrue(lang.isDisplayed(), "Переключатель языка должен отображаться");

//         lang.click();
//     }

//     @Test
//     public void testCurrencySelectorIsDisplayed() {
       
//         WebElement currency = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                 By.cssSelector("span[data-v-299b278e]")));
//         assertTrue(currency.isDisplayed(), "Выбор валюты должен отображаться");
//     }

//     @Test
//     public void testFindTicketsButtonIsClickable() {
//         WebElement search = headerPage.getSearchButton();
//         assertTrue(search.isDisplayed(), "Кнопка поиска билетов должна отображаться");

//         search.click();
//     }
//     @Test
// public void testInfantsBlockIsDisplayed() {
//     headerPage.getPeopleButton().click();

//     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//     WebElement infantsBlock = wait.until(
//         ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='people-infants']"))
//     );

//     assertTrue(infantsBlock.isDisplayed(), "Блок Infants отображается");
//* 

}

