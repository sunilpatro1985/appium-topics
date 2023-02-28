import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class IOSSampleTest {

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        //https://github.com/saucelabs/my-demo-app-rn/releases
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone SE (3rd generation)")
                .setPlatformVersion("15.5")
                .setBundleId("com.saucelabs.mydemoapp.rn");

                //.setApp("")
                //.setNoReset(true) //not install the app if it's already insatlled

        AppiumDriver driver = new IOSDriver(new URL("http://0.0.0.0:4723/"), options);

        driver.findElement(AppiumBy.accessibilityId("tab bar option menu")).click();
        //Thread.sleep(1000);

        By menuIcon = AppiumBy.accessibilityId("menu item log in");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(menuIcon)).click();

        Thread.sleep(1000);
        driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
        driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
        driver.findElement(AppiumBy.accessibilityId("Login button")).click();

        Thread.sleep(3000);
        driver.quit();
    }
}
