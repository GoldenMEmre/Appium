import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ArabamComTest {
    AndroidDriver<AndroidElement> driver;
    // Arabam kac para bolumune tiklayalim
// Aracimin fiyatini merak ediyorum bolumunetiklayalim
// Wolkswagen markasini secelim
// yil secimi yapalim
// model secimi yapalim
// govde tipini secelim
// yakit tipini secelim
// vites tipini secelim
// Versiyon secimi yapalim
// aracin km bilgilerini girelim
// aracin rengini secelim
// opsiyel donanim (varsa) seecelim
// degisen bilgisi ekleyerek tramer kaydi belirtelim
// aracimizin fiyatinin 500.000 tl den fazla oldugunu test edelim
// uygulamayi kapatalim

    @BeforeTest
    public void arabamTestSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel 2");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.dogan.arabam"); // Hangi uygulama uzerinde calismak istiyorsak apk infodan o uygulamanin degerini aliyoruz
        capabilities.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity"); // Uygulamayi actiktan sonra hangi sayfadan baslayacagimizi orn; Anasayfa, Profil, vb
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void arabamTest(){
//Burada driver.activateApp(); yapmamıza gerek yok. Çünkü yukarıda @Before test de bunu 38 ve 39. satırlar ile yaptık.
        // Uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // Uygulamanin basarili bir sekilde acildigi dogrulanir
        AndroidElement arabamLogo=driver.findElementById("com.dogan.arabam:id/ivArabamLogo");
        Assert.assertTrue(arabamLogo.isDisplayed());
        // Arabam kac para bolumune tiklayalim
        AndroidElement arabamKacPara=driver.findElementByXPath("//*[@text='Arabam kaç para?']");
        arabamKacPara.click();
        // Aracimin fiyatini merak ediyorum bolumunetiklayalim
        driver.findElementByXPath("//*[@text='Aracımın fiyatını merak ediyorum']").click();
        // Wolkswagen markasini secelim
        // yil secimi yapalim
        // model secimi yapalim
        // govde tipini secelim


    }

}

