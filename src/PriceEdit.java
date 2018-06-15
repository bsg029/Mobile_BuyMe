import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class PriceEdit {
    AndroidDriver<MobileElement> driver;

    public PriceEdit  (AndroidDriver driver) {
        this.driver = driver;
    }

    public void sendPrice()  {
        //insert amount
        WebElement priceSend = driver.findElementById(Constants.PutPrice);
        priceSend.sendKeys(Constants.HUNDRED);

    }

}
