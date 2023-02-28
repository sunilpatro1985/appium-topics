package trial;

import base.AppiumServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class

sauceHybridApp {

    @Test
    public static void sampleTest() throws MalformedURLException, InterruptedException {
        //WebDriverWait wait;
        AppiumServer.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE (3rd generation)")
                .setUdid("")
                .setPlatformVersion("16.2")
                .setPlatformName("ios")
                //.withBrowserName("safari")
                .setSafariAllowPopups(true)
                //.setBundleId("com.saucelabs.HybridApp");
                .setBundleId("com.saucelabs.mydemoapp.rn");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        //driver.get("https://qavbox.github.io/demo/signup/");

        //XCUIElementTypeButton[@name="test-swag-labs"]


        String parentView = driver.getContext();
        System.out.println("current view - " + parentView);
        System.out.println("before clicking the webview" + driver.getContextHandles());

        driver.findElement(AppiumBy.accessibilityId("tab bar option menu")).click();
        driver.findElement(AppiumBy.accessibilityId("menu item webview")).click();
       //should be displayed -  driver.findElement(AppiumBy.accessibilityId("Webview")).click();
        driver.findElement(AppiumBy.accessibilityId("URL input field")).sendKeys("https://www.google.com");
        Thread.sleep(1000);

        WebElement el = driver.findElement(AppiumBy.accessibilityId("Go To Site button"));
        Map<String, Object> params = new HashMap<>();
        params.put("elementId",((RemoteWebElement)el).getId());
        //params.put("x", 100);
        //params.put("y",50);
        ((JavascriptExecutor)driver).executeScript("mobile: doubleTap", params);

        Thread.sleep(1000);
       // new WebDriverWait(driver, Duration.ofSeconds(10000)).until(ExpectedConditions.invisibilityOfElementLocated(By.name("Loading ...")));
        Set<String> handles = driver.getContextHandles();
        System.out.println("handles - " + handles);
        driver.context((String)handles.toArray()[1]);
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[name='q']")).sendKeys("qavbox");
        Actions action=new Actions(driver);
        action.sendKeys(Keys.ENTER).build().perform();
        //driver.hideKeyboard(String.valueOf(Keys.ENTER));
        Thread.sleep(2000);
        //driver.findElement(AppiumBy.accessibilityId("Go")).click();
        //Assert.assertEquals(driver.findElements(By.cssSelector("#mobile-menu > li")).size(), 7);
        AppiumServer.stop();

    }
    
}
