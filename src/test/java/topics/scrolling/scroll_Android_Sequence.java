package topics.scrolling;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class scroll_Android_Sequence {

    static AppiumDriver driver;


    public static void main(String[] args) throws InterruptedException, MalformedURLException, MalformedURLException {

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("emulator-5554")
                .setPlatformVersion("12.0")
                //.setAppPackage("com.saucelabs.mydemoapp.rn")
                //.setAppActivity(".MainActivity");

                .setAppPackage("com.wdiodemoapp")
                .setAppActivity("com.wdiodemoapp.MainActivity");
        driver = new IOSDriver(new URL("http://0.0.0.0:4723"), options);

        driver.findElement(AppiumBy.accessibilityId("Swipe")).click();
        Thread.sleep(2000);

        scroll(ScrollDirection.DOWN, 0.5);
        Thread.sleep(1000);

        scroll(ScrollDirection.UP, 0.5);
        Thread.sleep(2000);
        scroll(ScrollDirection.RIGHT, 0.5);
        Thread.sleep(2000);
        scroll(ScrollDirection.LEFT, 0.5);
        Thread.sleep(2000);
        driver.quit();

    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

    public static void scroll(ScrollDirection dir, double scrollRatio){
        Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = scroll_Android_Sequence.driver.manage().window().getSize();
        System.out.println(size);
        Point midPoint = new Point((int)(size.width * 0.5),(int)(size.height * 0.5));
        int bottom = midPoint.y + (int)(midPoint.y * scrollRatio);
        int top = midPoint.y - (int)(midPoint.y * scrollRatio);
        //Point Start = new Point(midPoint.x, bottom );
        //Point End = new Point(midPoint.x, top );
        int left = midPoint.x - (int)(midPoint.x * scrollRatio);
        int right = midPoint.x + (int)(midPoint.x * scrollRatio);

        if (dir == ScrollDirection.UP) {
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (dir == ScrollDirection.DOWN) {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (dir == ScrollDirection.LEFT) {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }



        //Point Start = new Point(Right, midPoint.y );
        //Point End = new Point(Left, midPoint.y );

        //swipe(Start, End, );
    }

    protected static void swipe(Point start, Point end, Duration duration) {

        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        /*if (isAndroid) {
            duration = duration.dividedBy(ANDROID_SCROLL_DIVISOR);
        } else {
            swipe.addAction(new Pause(input, duration));
            duration = Duration.ZERO;
        }*/
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) scroll_Android_Sequence.driver).perform(ImmutableList.of(swipe));
    }


}
