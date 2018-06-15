import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import io.appium.java_client.android.AndroidKeyCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReceiveSend {

    AndroidDriver<MobileElement> driver;

    public ReceiveSend(AndroidDriver driver) {
        this.driver = driver;
    }

    public void sendTo() {
        //locators of sender and receiver page
        //receiver name
        WebElement toSend = driver.findElementById(Constants.Receiver);
        toSend.sendKeys (Constants.RECEIVER_NAME);

    }

    public void blessing() {
        //type blessing
        WebElement insertblessing = driver.findElementById(Constants.InsertBless);
        insertblessing.sendKeys (Constants.BLESSING);

    }

    public void clicknext() {

         //click a next key
        driver.pressKeyCode(AndroidKeyCode.BACK);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement next = driver.findElementById(Constants.NextKey);
        next.click();
    }

        public void choosemail() {
             // check box Mail
            List<MobileElement> mail  = driver.findElements(By.id(Constants.CheckMail));
            mail.get(2).click();

    }

        public void description() {
             // create touchaction object to scroll down a screen
            TouchAction action = new TouchAction(driver);
            //create point option object with current coordinates
            PointOption pointFromClickOption = new PointOption();
            pointFromClickOption.withCoordinates(1035,1913);
            //create point option object with coordinates to move
            PointOption pointToClickOption = new PointOption();
            pointToClickOption.withCoordinates(1035,1731);
            action.press(pointFromClickOption).moveTo(pointToClickOption).release().perform();
            // insert E-mail address
            WebElement insertmail = driver.findElement(By.className(Constants.InsertMailAddress));
            insertmail.sendKeys (Constants.MAIL);

        }

}
