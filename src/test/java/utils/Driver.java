package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Driver {

    private static AndroidDriver appiumDriver;//Private; singelton pattern'de kullanılıyor, sadece burada class içerisinde
//kullanılabiliyor başka classlardan obje oluşturamıyoruz,ama buradaki private AndroidDriver aşağıdaki gibi public bir
    static final String TELEFONADI = "PIXEL2";//Final olunca başka değer atayıp değiştiremiyoruz.
    static final String ANDROIDVERSION = "10.0";
    static final String PLATFORM = "Android";
    static final String OTOMASYON_ISMI = "UiAutomator2";
//methodun içerisinde kullanılırsa diğer classlarda bu AndroidDriver kullanılabilir.
    public static AndroidDriver getAndroidDriver() {//public olduğu için diğer class'larda obje oluşturularak çağrılabilir.
        URL appiumServerURL = null;//Bu server üzerinden değerlerimizi göndereceğiz.
        try {
            appiumServerURL = new URL("http:127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if (appiumDriver == null) {//Driver boşsa aşağıdaki tanımlamalarımızı gönder

            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, TELEFONADI);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, ANDROIDVERSION);
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM);
            caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, OTOMASYON_ISMI);
            caps.setCapability("appPackage", "com.smartwho.SmartAllCurrencyConverter"); // Hangi uygulama uzerinde calismak istiyorsak apk infodan o uygulamanin degerini aliyoruz
            caps.setCapability("appActivity", "com.smartwho.SmartAllCurrencyConverter.CurrencyConverter"); // Uygulamayi actiktan sonra hangi sayfadan baslayacagimizi orn; Anasayfa, Profil, vb
            //caps.setCapability(MobileCapabilityType.NO_RESET, false);
            // true uygulama sifirlanmiyor onceki adimlari muhafaza ediyor
            //false ise her test baslangicinda uygulamayi sifirliyor ve uygulama en bastan basliyor

            if (ConfigReader.getProperty("platformName").equals("Android")) {//Bunun için de conf.prop.'e platform name ekle.
//Platform olarak Android kullan, değilse geçersiz de.// con.prop.'tan gelen değer android ise appiumDriver'a new AndroidDriver
                assert appiumServerURL != null;//değeri gönder(yukarıda yaptığım cap tanımlamalarıyla)(s.44)
                appiumDriver = new AndroidDriver<>(appiumServerURL, caps);
                appiumDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            } else {
//Eğer android değilse hata mesajı ver. İşlemi sona erdir
                throw new UnsupportedOperationException("Invalid Platform Name ");

            }

        }
//if bloğu çalışırsa bana bunu döndür.
        return appiumDriver;
    }


    public static void quitAppiumDriver() {
        if (appiumDriver != null) {
            appiumDriver.closeApp();
            appiumDriver = null;
        }
    }
}
//1. gün desired.capabilities'leri testin içinde oluşturduk
//3. gün BeforeTest'in içine aldık
//Artık bundan sonra Driver classını kullanacağız.