package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.time.Duration;

//AndridDriver Selenium Driver'ın API'larını kullanarak bağlantı sağlar.Android Driver'ı Selenium Driver gibi
public class KiwiPage {//kullanabilmemiz ve locate'leri burada oluşturabilmemiz için, casting işlemi yapmamız
    public KiwiPage(){// gerekiyor. And.Drv.'ı WebDri.'a cast yaparak, PageFac'den gelen init.'le birlikte
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);//kaydettiğim locate'leri
    }//tıpkı Selenium WebDri. üzerinden kullandığım gibi MobilElementler üzerinden kullanabiliyoruz.

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafir;

    @FindBy(xpath ="//*[@class='android.widget.EditText']" )
    public WebElement departureBox;

    @FindBy(xpath = "//*[@text='Choose']")
    public WebElement chooseButton;

    @FindBy(id = "com.skypicker.main:id/saveButton")
    public WebElement saveButton;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[12]")
    public WebElement fiyat;


    public void ucAdimGecme(int iBaslangic,int iBitis,int xKoordinat,int yKoordinat,int bekleme) throws InterruptedException {
        TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());
        for (int i=iBaslangic; i<iBitis; i++){
            touchAction.press(PointOption.point(xKoordinat,yKoordinat)).release().perform();
            Thread.sleep(bekleme);
        }
    }

    public void koordinatTiklama(int xKoordinat,int yKoordinat,int bekleme) throws InterruptedException {
        TouchAction touchAction=new TouchAction<>(Driver.getAndroidDriver());
        touchAction.press(PointOption.point(xKoordinat,yKoordinat)).release().perform();
        Thread.sleep(bekleme);
    }

    public void ekranAltKaydirma(int xKoordinat,int yKoordinat,int wait,int mxKoordinat,int myKoordinat,int bekleme) throws InterruptedException {
        TouchAction touchAction = new TouchAction<>(Driver.getAndroidDriver());
        touchAction
                .press(PointOption.point(xKoordinat, yKoordinat))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(wait)))
                .moveTo(PointOption.point(mxKoordinat, myKoordinat))
                .release()
                .perform();
        Thread.sleep(bekleme);
    }


    }

