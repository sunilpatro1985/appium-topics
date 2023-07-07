package topics.scrolling;

import base.AppDriver;
import base.AppFactory;
import base.AppiumServer;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class IOSContactsScroll {

    @Test
    public static void iosSwipeGesture_plugin() throws InterruptedException, MalformedURLException, MalformedURLException {
        //AppiumServer.start();
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 14 Pro Max")
                .setPlatformVersion("16.2")
                .setBundleId("com.apple.MobileAddressBook");

        AppFactory.ios_launchApp(options);

        //Util.scroll(Util.ScrollDirection.DOWN, 0.5);
        //Util.scrollNclick(By.xpath("//XCUIElementTypeOther[@name='ContactsListView']//XCUIElementTypeCell")
        // ,"name", "QAVBOX");
        //Util.scrollNclick(By.name("QAVBOX"));

        WebElement el = AppDriver.getDriver().findElement(AppiumBy.accessibilityId("ContactsListView"));
        Util.swipe_gesturePlugin(el,"up");
        Thread.sleep(2000);
        AppDriver.getDriver().quit();
    }


    public static void main(String[] args) throws InterruptedException, MalformedURLException, MalformedURLException {
        AppiumServer.start();
        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone SE (3rd generation)")
                .setPlatformVersion("16.2")
                .setBundleId("com.apple.MobileAddressBook");

        AppFactory.ios_launchApp(options);

        //Util.scroll(Util.ScrollDirection.DOWN, 0.5);
        //Util.scrollNclick(By.xpath("//XCUIElementTypeOther[@name='ContactsListView']//XCUIElementTypeCell")
                           // ,"name", "QAVBOX");
        Util.scrollNclick(By.name("QAVBOX"));
        Thread.sleep(2000);
        AppDriver.getDriver().quit();
    }
    }
