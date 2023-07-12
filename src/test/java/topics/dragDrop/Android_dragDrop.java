package topics.dragDrop;

import base.AppDriver;
import base.AppFactory;
import base.Util;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Map;

public class Android_dragDrop {

    @Test
    public static void DD_Test() throws InterruptedException, MalformedURLException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("13.0")
                //.setAppPackage("com.saucelabs.mydemoapp.rn")
                //.setAppActivity(".MainActivity");
                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity");
        AppFactory.android_launchApp(options);

        Thread.sleep(2000);

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("Drag")).click();

        Thread.sleep(1000);

        /*WebElement source = (AppDriver.getDriver()).findElement(AppiumBy.accessibilityId("drag-l2"));
        //Thread.sleep(2000);
        WebElement target = (AppDriver.getDriver()).findElement(AppiumBy.accessibilityId("drop-l2"));
        //Thread.sleep(2000);

        Util.dragNDrop(source, target);*/

        WebDriverWait wait = new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(30));
        RemoteWebElement source = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("drag-l2")));
        RemoteWebElement destination = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("drop-l2")));


        Thread.sleep(3000);
        AppDriver.getDriver().quit();

    }
}
