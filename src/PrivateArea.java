import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class PrivateArea {

    AndroidDriver<MobileElement> driver;

    public PrivateArea  (AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickPrivateArea()  {
       // WebElement privateAreaClick = driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(il.co.mintapp.buyme:id/profileTab)");
        WebElement privateAreaClick = driver.findElementById("il.co.mintapp.buyme:id/profileTab");

        privateAreaClick.click();

    }
}

