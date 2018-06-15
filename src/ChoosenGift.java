import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ChoosenGift {

    AndroidDriver<MobileElement> driver;

    public ChoosenGift  (AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickchoosen()  {

        //select a business
        WebElement el = driver.findElementByAndroidUIAutomator("new UiSelector().className(android.widget.RelativeLayout).index(1)");
        el.click();    }
}
