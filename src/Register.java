import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class Register {

    AndroidDriver<MobileElement> driver;

    public Register  (AndroidDriver driver) {
        this.driver = driver;
    }

    public void clickRegister()  {
        //registration
        WebElement RegisterClick = driver.findElementById(Constants.Registration);
        RegisterClick.click();

    }

    public void clickWithGoogle() {
             // select by Google
        WebElement GoogleClick = driver.findElementById(Constants.ByGoogle);
        GoogleClick.click();
    }


}
