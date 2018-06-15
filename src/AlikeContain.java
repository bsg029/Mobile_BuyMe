import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class AlikeContain {

    AndroidDriver<MobileElement> driver;

    public AlikeContain  (AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickAlike()  {
        WebElement alikeContain = driver.findElementById(Constants.Continue);
        alikeContain.click();

    }

}
