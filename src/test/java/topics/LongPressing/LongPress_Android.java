package topics.LongPressing;

import base.AppDriver;
import base.AppFactory;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class LongPress_Android {
    public static void main(String[] args) throws InterruptedException, MalformedURLException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName("emulator-5554")
                .setPlatformVersion("12.0")
                //.setAppPackage("com.saucelabs.mydemoapp.rn")
                //.setAppActivity(".MainActivity");
                .setAppPackage("com.android.dialer")
                .setAppActivity(".main.impl.MainActivity");

        AppFactory.android_launchApp(options);
        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("key pad")).click();
        WebElement zero = AppDriver.getDriver().findElement(AppiumBy.accessibilityId("0"));
        Util.longPress(zero);
        Thread.sleep(1000);
        zero.click();

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("8,TUV")).click();
        Thread.sleep(1000);

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("8,TUV")).click();
        zero.click();
        Thread.sleep(1000);


        WebElement backSpace = AppDriver.getDriver().findElement(AppiumBy.accessibilityId("backspace"));
        backSpace.click();
        Thread.sleep(2000);

        Util.longPress(backSpace);
        Thread.sleep(4000);
        AppDriver.getDriver().quit();

    }

}
