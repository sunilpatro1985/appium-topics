package topics.web;

import base.AppDriver;
import base.AppFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class IOSSafariBr {

    @Test
    public static void IOSSafariBrTest() throws MalformedURLException, InterruptedException {
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14")
                .setPlatformVersion("16.2")
                //.setSafariAllowPopups(true)
                .withBrowserName("safari");

        AppFactory.ios_launchApp(options);

        Thread.sleep(2000);

        AppDriver.getDriver().get("https://saucedemo.com");

        Thread.sleep(1000);

        AppDriver.getDriver().findElement(By.id("user-name")).sendKeys("standard_user");
        AppDriver.getDriver().findElement(By.id("password")).sendKeys("secret_sauce1");

        AppDriver.getDriver().findElement(By.id("login-button")).click();

        new WebDriverWait( AppDriver.getDriver(), Duration.ofSeconds(30))
                .until(ExpectedConditions.presenceOfElementLocated(By.className("app_logo")));

        Thread.sleep(2000);
        AppDriver.getDriver().quit();


    }
}
