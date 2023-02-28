
  package trial;

import base.AppiumServer;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

  public class Android_nativeToWeb {


      @Test
      public static void sampleTest_android() throws MalformedURLException, InterruptedException {

          AppiumServer.start();

          UiAutomator2Options options = new UiAutomator2Options();
          options.setDeviceName("emulator-5554")
                  .setPlatformVersion("12.0")
                  .setAppPackage("com.wdiodemoapp")
                  .setAppActivity("com.wdiodemoapp.MainActivity");

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

          driver.findElement(By.xpath("//*[@aria-label='Toggle navigation bar']")).click();
          driver.findElement(By.xpath("//*[@class='toggle_vylO margin-right--md']")).click();
          driver.findElement(By.xpath("//*[@class='clean-btn navbar-sidebar__close']")).click();

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




  //appium --allow-insecure chromedriver_autodownload
  //https://appium.io/docs/en/writing-running-appium/web/chromedriver/
  //appiumandroidswitchissuechromedriverversion.jpg
