
  package topics;

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

public class nativeToWeb {


    @Test
    public static void sampleTest() throws MalformedURLException, InterruptedException {

        AppiumServer.start();

        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE (3rd generation)")
                .setPlatformVersion("16.2")
                .setPlatformName("ios")
                .setSafariAllowPopups(true)
                .setBundleId("org.wdioNativeDemoApp");

        IOSDriver driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);

        System.out.println("Current context " + driver.getContext());
        System.out.println("handles " + driver.getContextHandles());

        driver.findElement(AppiumBy.accessibilityId("Webview")).click();
        Thread.sleep(3000);
        System.out.println("handles " + driver.getContextHandles());

        Set<String> handles = driver.getContextHandles();
        driver.context((String) handles.toArray()[1]); // we are on webview
        Thread.sleep(1000);
        System.out.println("after switch webview, Current context " + driver.getContext());

        driver.findElement(By.cssSelector("[class='buttons_pzbO'] [href='/docs/gettingstarted']")).click();
        Thread.sleep(2000);

        driver.context("NATIVE_APP");
        driver.findElement(AppiumBy.accessibilityId("Login")).click();
        driver.findElement(AppiumBy.accessibilityId("input-email")).sendKeys("qavbox");
        Thread.sleep(2000);

        driver.quit();

        AppiumServer.stop();

    }

}

