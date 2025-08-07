package com.twelvego.tests;

import com.twelvego.config.BaseTest;
import com.twelvego.pages.HeaderPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckSearchTour extends BaseTest {

    private HeaderPage headerPage;

    @BeforeEach
    void initPage() {
        headerPage = new HeaderPage(driver);
    }

    @Test
    public void checkSearchTourTest() {
        // Ввод маршрута
        headerPage.fieldFrom("Krabi");
        headerPage.fieldTo("Pattaya");

        // Выбор первой даты (через календарь)
        headerPage.getDateFirstButton().click();
        headerPage.selectDateFromCalendarPlusDays(4);

        // Выбор второй даты 
        headerPage.getDateSecondButton().click();
        headerPage.selectDateFromCalendarPlusDays(6);

        // Установка количества пассажиров
        headerPage.setAdultsCount(3);
        headerPage.setChildrenCount(3);

        // Нажатие кнопки поиска
        headerPage.getSearchButton().click();

        // Ожидание загрузки результатов
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[data-qa='result-card']")));

        // Проверкарезультаты поиска отобразились
        assertTrue(driver.findElement(By.cssSelector("[data-qa='result-card']")).isDisplayed(),
                "Результаты поиска должны отображаться");
    }
}
