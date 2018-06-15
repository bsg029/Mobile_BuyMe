import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class ToBuy {

    AndroidDriver<MobileElement> driver;

    public ToBuy  (AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickToBuy()  {
        WebElement buy = driver.findElementById(Constants.To_Buy);

        buy.click();

    }

}
