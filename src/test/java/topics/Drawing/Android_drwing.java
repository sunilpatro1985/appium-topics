package topics.Drawing;

import base.AppDriver;
import base.AppFactory;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;

public class Android_drwing {

    @Test
    public static void DD_Test() throws InterruptedException, MalformedURLException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("12.0")
                //.setAppPackage("com.saucelabs.mydemoapp.rn")
                //.setAppActivity(".MainActivity");
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity");
        AppFactory.android_launchApp(options);

        Thread.sleep(2000);

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("open menu")).click();

        Thread.sleep(1000);
        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("menu item drawing")).click();
        Thread.sleep(1000);

        WebElement drawingPane = AppDriver.getDriver()
                .findElement(AppiumBy.xpath("//android.view.View[@resource-id='signature-pad']"));
        //System.out.println(AppDriver.getDriver().findElement(AppiumBy.xpath("//android.view.View[@resource-id='signature-pad']")).getLocation());
        Util.Drawing(drawingPane); //top to bottom



        /*WebElement source = (AppDriver.getDriver()).findElement(AppiumBy.accessibilityId("drag-l2"));
        //Thread.sleep(2000);
        WebElement target = (AppDriver.getDriver()).findElement(AppiumBy.accessibilityId("drop-l2"));
        //Thread.sleep(2000);

        Util.dragNDrop(source, target);*/
        /*
        WebDriverWait wait = new WebDriverWait(AppDriver.getDriver(), Duration.ofSeconds(30));
        RemoteWebElement source = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("drag-l2")));
        RemoteWebElement destination = (RemoteWebElement) wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("drop-l2")));
        */

        Thread.sleep(3000);
        AppDriver.getDriver().quit();

    }
}
