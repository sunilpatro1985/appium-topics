package trial;

import base.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class WebToNative {


    @Test
    public static void sampleTest() throws MalformedURLException, InterruptedException {

        //AppiumServer.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE (3rd generation)")
                .setUdid("")
                .setPlatformVersion("16.2")
                .setPlatformName("ios")
                .withBrowserName("safari")
                .setSafariAllowPopups(true);
                //.setBundleId("com.saucelabs.mydemoapp.rn");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
        driver.get("https://qavbox.github.io/demo/signup/");

        System.out.println("before clicking the submit" + driver.getContextHandles());
        String webView = driver.getContext();
        System.out.println("webview - " + webView);
        driver.findElement(By.cssSelector("#submit")).click();

        //System.out.println("after clicking the submit" + ((IOSDriver)driver).getContextHandles());
        Thread.sleep(2000);
        System.out.println("after alert" + driver.getContext());
        //driver.switchTo().alert().accept();
        driver.context("NATIVE_APP");
        Thread.sleep(2000);
        driver.findElement(By.name("Close")).click();
        driver.context(webView);
        System.out.println("title - " + driver.getTitle());
        AppiumServer.stop();

    }
    
}
//.mobile-navigation