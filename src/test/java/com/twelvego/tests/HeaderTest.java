package com.twelvego.tests;

import com.twelvego.config.BaseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertTrue;

import java.beans.Transient;
import com.twelvego.pages.HeaderPage;


public class HeaderTest extends BaseTest {

// private WebDriver driver;
private HeaderPage headerPage;

// //  @BeforeEach
//     public void setUp() {
//         driver.get("\"https://12go.asia/en/\"");
//         headerPage = new HeaderPage(driver);
//     }
 
//     @AfterAll
//     public void tearDown() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }

@BeforeEach
void initPage() {
    headerPage = new HeaderPage(driver);
}

@Test
    public void testFromFieldIsClickable() {
        assertTrue(headerPage.getFromButton().isDisplayed(), "Поле From отображается");
        headerPage.getFromButton().click();
    }
 
    @Test
    public void testToFieldIsClickable() {
        assertTrue(headerPage.getToButton().isDisplayed(), "Поле To отображается");
        headerPage.getToButton().click();
    }


@Test 

public void testDatepickerButtonIsClickable() {
    WebElement datepickerButton = driver.findElement(By.cssSelector("div[data-qa='datepicker-button']"));
    assertTrue(datepickerButton.isDisplayed(), "Кнопка выбора даты отображается");
    datepickerButton.click();

  }

@Test 

public void testDatepickerRangeButtonIsClickable() {
    WebElement datapickerRangeButton = driver.findElement(By.cssSelector("div[data-qa='datepicker-button-range']"));
    assertTrue(datapickerRangeButton.isDisplayed(), "Кнопка выбора даты отображается");
    datapickerRangeButton.click();

  }

@Test 

public void testFieldPeopleButtonIsClickable() {
    WebElement testFieldPeopleButton = driver.findElement(By.cssSelector("div[data-qa='people-button']"));
    assertTrue(testFieldPeopleButton.isDisplayed(), "Кнопка выбора колличества людей отображается");
    testFieldPeopleButton.click();

  }

@Test 

public void testLogoIsDisplayed() {
    boolean isLogoVisible = driver.findElement(By.cssSelector("a[data-qa='logo-component']")).isDisplayed();
    assertTrue(isLogoVisible, "Логотип отображается");

  }

@Test

public void testSupportLinkIsClickable() {

    WebElement supportLink = driver.findElement(By.cssSelector("a[href='/en/faq']"));
    assertTrue(supportLink.isDisplayed(), "Ссылка поддержки отображается");
    supportLink.click();

  }

@Test

public void testLanguageSelectorIsClickable() {
    WebElement languageSelector = driver.findElement(By.cssSelector("span[data-qa='lang-selector']"));
    
    assertTrue(languageSelector.isDisplayed(), "Кнопка выбора языка отображается");
    
    languageSelector.click();
  }

  @Test

public void testCurrencySelectorIsDisplayedByClass() {
    WebElement currencyElement = driver.findElement(By.cssSelector("span[data-v-299b278e]"));

    assertTrue(currencyElement.isDisplayed(), "Элемент валюты отображается");
  }

@Test 

public void testFindTicketsIsClickable() {
    //Поиск кнопки
    WebElement searchButton = driver.findElement(By.cssSelector("button[data-qa='search-form-submit-button']"));

    //Проверка что кнопка отображается
    assertTrue(searchButton.isDisplayed(), "Кнопка поиска билетов отображается");

    //Нажимаем на кнопку
    searchButton.click();
    
   }
}

