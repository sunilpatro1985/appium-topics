package topics.drawing;

import base.AppDriver;
import base.AppFactory;
import base.AppiumServer;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URL;

public class DrawingAndrtest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //https://github.com/saucelabs/my-demo-app-rn/releases

        //AppiumServer.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("13.0")
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

        Util.Drawing(drawingPane);

        Thread.sleep(3000);

        AppDriver.getDriver().quit();


    }
}
