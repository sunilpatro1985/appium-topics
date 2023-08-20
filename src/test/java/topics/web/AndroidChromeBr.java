package topics.web;

import base.AppDriver;
import base.AppFactory;
import base.AppiumServer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class AndroidChromeBr {

    @Test
    public static void BrTestChrome() throws MalformedURLException, InterruptedException {
        AppiumServer.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("12.0")
                .withBrowserName("chrome");
                //.setAppPackage("com.android.chrome")
                //.setAppActivity("com.google.android.apps.chrome.Main")
                        //.autoGrantPermissions();
                AppFactory.android_launchApp(options);
        Thread.sleep(1000);
        /*System.out.println(((AndroidDriver)AppDriver.getDriver()).getContext());

        ((AndroidDriver)AppDriver.getDriver()).context("WEBVIEW_chrome");
        System.out.println(((AndroidDriver)AppDriver.getDriver()).getContext());*/
        Thread.sleep(1000);


        AppDriver.getDriver().get("https://qavbox.github.io/demo/signup/");
        AppDriver.getDriver().findElement(By.id("email")).sendKeys("qavbox@gmail.com");

        Thread.sleep(2000);
        AppDriver.getDriver().quit();
        AppiumServer.stop();

        //appium --allow-insecure chromedriver_autodownload
        //https://github.com/appium/appium/issues/17492
        //android 13 with chrome < 110 will be having some issue


    }
}
