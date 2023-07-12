package topics.dragDrop;

import base.AppDriver;
import base.AppFactory;
import base.Util;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IOS_dragDrop {

    @Test
    public static void DD_Test() throws InterruptedException, MalformedURLException, MalformedURLException {

        XCUITestOptions options = new XCUITestOptions()
                .setDeviceName("iPhone 14")
                .setPlatformVersion("16.2")
                .setBundleId("org.wdioNativeDemoApp");
        AppFactory.ios_launchApp(options);

        Thread.sleep(2000);

        AppDriver.getDriver().findElement(AppiumBy.accessibilityId("Drag")).click();

        for(int i=0; i<getSourceItems().size();i++){
            Util.dragNDrop(getEl(getSourceItems().get(i)), getEl(getTargetItems().get(i)));
            Thread.sleep(500);
        }


        Thread.sleep(4000);
        AppDriver.getDriver().quit();
    }

    static ArrayList<String> getSourceItems(){
        ArrayList<String> sourceItems = new ArrayList<String>(
                Arrays.asList("drag-l1", "drag-l2", "drag-l3",
                        "drag-c1", "drag-c2", "drag-c3",
                        "drag-r1", "drag-r2", "drag-r3"));
        return sourceItems;
    }

    static ArrayList<String> getTargetItems() {
        ArrayList<String> targetItems = new ArrayList<String>(
                Arrays.asList("drop-l1", "drop-l2", "drop-l3",
                        "drop-c1", "drop-c2", "drop-c3",
                        "drop-r1", "drop-r2", "drop-r3"));
        return targetItems;
    }

    static WebElement getEl(String item){
        return AppDriver.getDriver().findElement(AppiumBy.accessibilityId(item));
    }

}
