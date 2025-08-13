package com.twelvego.config;
 
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
import java.time.Duration;
 
public abstract class BaseTest {
 
    protected static WebDriver driver;
    protected static WebDriverWait wait;
 
    @BeforeAll
    static void setUpClass() {
        WebDriverManager.chromedriver().setup();
 
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--headless=new");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
 
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
 
    @AfterAll
    static void tearDownClass() {
        if (driver != null) driver.quit();
    }
 
    @BeforeEach
    void openHomePage() {
        driver.get("https://12go.asia/en/");
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}