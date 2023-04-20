package base;

import com.google.common.collect.ImmutableList;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;

public class Util {
    static double SCROLL_RATIO = 0.5;

    public static void scrollNclick(By listItems, String attrName, String text) throws InterruptedException {
        String prevPageSource = "";
        boolean flag = false;

        while(!isEndOfPage(prevPageSource)){
            prevPageSource = AppDriver.getDriver().getPageSource();

            for(WebElement el: AppDriver.getDriver().findElements(listItems)){

                if(el.getAttribute(attrName).equalsIgnoreCase(text)){
                    el.click();
                    flag=true; //come out of the for loop
                    break;
                }
            }
            if(flag)
                break; //come out of the while loop
            else {
                scroll(ScrollDirection.DOWN, Util.SCROLL_RATIO);
                Thread.sleep(1000);
            }

        }

    }

    public static void scrollNclick(By byEl){
        String prevPageSource = "";
        boolean flag = false;

        while(!isEndOfPage(prevPageSource)) {
            prevPageSource = AppDriver.getDriver().getPageSource();

            try{
                AppDriver.getDriver().findElement(byEl).click();
            }catch(org.openqa.selenium.NoSuchElementException e){
                scroll(ScrollDirection.DOWN, Util.SCROLL_RATIO);
            }
        }

    }

    public static boolean isEndOfPage(String pageSource){
        return pageSource.equals(AppDriver.getDriver().getPageSource());
    }

    public enum ScrollDirection {
        UP, DOWN, LEFT, RIGHT
    }

    public static void scroll(ScrollDirection dir, double scrollRatio){
        Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = AppDriver.getDriver().manage().window().getSize();
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
        ((AppiumDriver) AppDriver.getDriver()).perform(ImmutableList.of(swipe));
    }

    public static void longPress(WebElement el) {
        Point location = el.getLocation();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        ((AppiumDriver) AppDriver.getDriver()).perform(ImmutableList.of(swipe));
    }
}
