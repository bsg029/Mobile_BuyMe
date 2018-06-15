import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.junit.*;
import org.junit.rules.TestName;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.fail;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class Report {

    @Rule
    public TestName name = new TestName();

    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent ;

    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test ;

    // private static AndroidDriver driver;
    private static AndroidDriver<MobileElement> driver;

    @BeforeClass

    public static void setUp() throws IOException, InterruptedException {

         ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("C://Semion//mobile_buyme.html");

        // choose to append each test
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        test = extent.createTest("Mobile Automating BuyMe", "Mobile BuyMe sanity test.");

        // add custom system info
          extent.setSystemInfo("Environment", "Production");
          extent.setSystemInfo("Tester", "Semion");

        // log results
         test.log(Status.INFO, "@Before class");

        boolean driverEstablish = false;
        try {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.
                PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
        capabilities.setCapability("appPackage", "il.co.mintapp.buyme");
        capabilities.setCapability("appActivity","il.co.mintapp.buyme.activities.common.SplashScreen");
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 120);
        capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub/"), capabilities);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        } catch (Exception e) {
            e.printStackTrace();
            fail("Cant open application");
            test.log(Status.FATAL, "Driver Connection Failed! " + e.getMessage());
            driverEstablish = false;
        } finally {
            if (driverEstablish) {
                test.log(Status.PASS, "Driver established successfully");

            }
        }

        Thread.sleep(2000);

    }
//Registration screen
//    @Test
//
//    public void test1_choosePrivateArea () throws InterruptedException {
//        Thread.sleep(2000);
//
//        PrivateArea privateArea = new PrivateArea(driver);
//        privateArea.clickPrivateArea();
//
//    }
//
//    @Test
//
//    public void test2_chooseRegister ()  {
//
//        Register registerArea = new Register(driver);
//        registerArea.clickRegister();
//
//    }

    @Test
    public void test3_chooseGiftCard()  {

        boolean giftValidated = false;
        try {

        ChoosenGift gift = new ChoosenGift(driver);
        gift.clickchoosen();

        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Select business " + e.getMessage());
            giftValidated = false;
        } finally {
            if (giftValidated) {
                test.log(Status.PASS, "Business was selected successfully");

            }
        }

    }

    @Test

    public void test4_chooseShovarCard () throws IOException {
        // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Semion\\" + name.getMethodName())).build());
        ChooseShovar shovar = new ChooseShovar(driver);
        boolean chooseshovar = false;
        try {

            shovar.clickchoosenshovar();
            chooseshovar = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to choose a card" + e.getMessage());
            chooseshovar = false;
        } finally {
            if (chooseshovar) {
                test.log(Status.PASS, "Card choices passed successfully");

            }
        }

    }

    @Test

    public void test5_sendPriceGift () throws IOException {
        // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Semion\\" + name.getMethodName())).build());

        PriceEdit price = new PriceEdit(driver);
        boolean insertPriceGiftCard = false;
        try {
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
         //insert a price
        price.sendPrice();
            insertPriceGiftCard = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to insert a price" + e.getMessage());
            insertPriceGiftCard = false;
        } finally {
            if (insertPriceGiftCard) {
                test.log(Status.PASS, "A price sent successfully");

            }
        }
    }

    @Test

    public void test6_toBuy () throws IOException {
        // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Semion\\" + name.getMethodName())).build());
        // Buy key
        ToBuy buy = new ToBuy(driver);
        boolean clickbuykey = false;
        try {
            // Enter receiver name
            // click a "buy key"
            buy.clickToBuy();
            clickbuykey = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to click on Buy key" + e.getMessage());
            clickbuykey = false;
        } finally {
            if (clickbuykey) {
                test.log(Status.PASS, "Buy key was clicked successfully");
            }
        }
    }

    @Test

    public void test7_alikeContain () throws IOException {
        // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Semion\\" + name.getMethodName())).build());

        AlikeContain contain = new AlikeContain(driver);
        boolean clickcontain = false;
        try {
        contain.clickAlike();
            clickcontain = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to click" + e.getMessage());
            clickcontain = false;
        } finally {
            if (clickcontain) {
                test.log(Status.PASS, "Click successfully");
            }
        }
    }

    @Test

    public void test8_receiverSender () throws IOException, InterruptedException {
        Thread.sleep(2000);
        // add screenshot
        test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot("C:\\Semion\\" + name.getMethodName())).build());

        ReceiveSend toFrom = new ReceiveSend(driver);
        boolean uploadSendReceiverInfo = false;
        try {
            //receiver name
        toFrom.sendTo();
            // insert blessing
        toFrom.blessing();
            // click a next button
        toFrom.clicknext();
            // select mail box
        toFrom.choosemail();
             // insert E-mail address
        toFrom.description();
             // select a next button
        toFrom.clicknext();

            uploadSendReceiverInfo = true;
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Failed to upload Send-Receiver info" + e.getMessage());
            uploadSendReceiverInfo = false;
        } finally {
            if (uploadSendReceiverInfo) {
                test.log(Status.PASS, "Send-Receiver info was uploaded successfully");
            }
        }
    }

    @AfterClass

    public static void afterClass() {
        test.log(Status.INFO, "@After test " + "After test method");
        driver.quit();
        // build and flush report
        extent.flush();
    }

    //Util to take ScreenShot
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath+".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath+".png";
    }


}



