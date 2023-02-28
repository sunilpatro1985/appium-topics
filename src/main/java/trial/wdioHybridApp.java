package trial;

import base.AppiumServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class wdioHybridApp {


    @Test
    public static void sampleTest() throws MalformedURLException, InterruptedException {

        AppiumServer.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE (3rd generation)")
                .setUdid("")
                .setPlatformVersion("16.2")
                .setPlatformName("ios")
                //.withBrowserName("safari")
                .setSafariAllowPopups(true)
                //.setBundleId("com.saucelabs.HybridApp");
                //.setBundleId("com.saucelabs.mydemoapp.rn");
                .setBundleId("org.wdioNativeDemoApp");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        //driver.get("https://qavbox.github.io/demo/signup/");

        //XCUIElementTypeButton[@name="test-swag-labs"]


        String parentView = driver.getContext();
        System.out.println("current view - " + parentView);
        System.out.println("before clicking the webview" + driver.getContextHandles());


        driver.findElement(AppiumBy.accessibilityId("Webview")).click();

        Set<String> handles = new HashSet<>();
        handles = driver.getContextHandles();

        driver.context((String) handles.toArray()[1]);
        System.out.println("after click webview" + driver.getContext());
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("[class='buttons_pzbO'] [href='/docs/gettingstarted']")).click();
        System.out.println(driver.getCurrentUrl());
        driver.context("NATIVE_APP");
        Thread.sleep(2000);
        driver.findElement(AppiumBy.accessibilityId("Login")).click();
        driver.findElement(AppiumBy.accessibilityId("input-email")).sendKeys("qavbox");

        //name navigation back button

        //name         tab bar option menu

        //driver.findElement(By.cssSelector("#submit")).click();

        //System.out.println("after clicking the submit" + ((IOSDriver)driver).getContextHandles());
        /*Thread.sleep(2000);
        System.out.println("after alert" + driver.getContext());
        //driver.switchTo().alert().accept();
        driver.context("NATIVE_APP");
        Thread.sleep(2000);
        driver.findElement(By.name("Close")).click();
        driver.context(webView);
        System.out.println("title - " + driver.getTitle());*/
        AppiumServer.stop();

    }
    
}
