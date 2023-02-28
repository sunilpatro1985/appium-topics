import base.AppiumServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class AndroidSampleTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //https://github.com/saucelabs/my-demo-app-rn/releases

        AppiumServer.start();

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("11.0")
                .setAppPackage("com.saucelabs.mydemoapp.rn")
                .setAppActivity(".MainActivity");

        //.setApp("")
        //.setNoReset(true) //not install the app if it's already insatlled

        AppiumDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);

        driver.findElement(AppiumBy.accessibilityId("open menu")).click();
        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();

        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

        Thread.sleep(3000);

        driver.quit();

        AppiumServer.stop();
    }
}
