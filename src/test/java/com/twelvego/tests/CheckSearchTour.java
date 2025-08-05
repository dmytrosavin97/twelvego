package com.twelvego.tests;

import com.twelvego.config.BaseTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

import java.beans.Transient;
import com.twelvego.pages.HeaderPage;




public class CheckSearchTour extends BaseTest {

private HeaderPage headerPage;

    @BeforeEach
void initPage() {
    headerPage = new HeaderPage(driver);
}

@Test 
public void checkSearchTourTest() {

headerPage.fieldFrom("Krabi");

headerPage.fieldTo("Pattaya");

headerPage.dateFirst("Fri, Jul 11");

headerPage.dateSecond("Thu, Aug 7");


    }
}

