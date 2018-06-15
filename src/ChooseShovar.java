import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import java.util.List;

public class ChooseShovar {

        AndroidDriver<MobileElement> driver;

        public ChooseShovar  (AndroidDriver driver) {
            this.driver = driver;
        }

        public void clickchoosenshovar()  {
            //select a card
            List<MobileElement> list = driver.findElements(By.id(Constants.Shovar));
            list.get(0).click();
        }
    }



