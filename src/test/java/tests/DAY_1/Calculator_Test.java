package tests.DAY_1;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Calculator_Test {

    AndroidDriver<AndroidElement> driver;// Android cizahlar icin kullanilmasi gerek driver
    //AppiumDriver<AndroidElement> driver2;// hem android hem de ios cihazlar icin kullanilabilen driver(Android icin bu driver kullanilabilir)
    //AppiumDriver<MobileElement> driver3; // ios icin kullanilir (Android cihazlar icin de kullanilabilir)

    @Test
    public void test1() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"Pixel");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");// Eger ki kullandigimiz android surumu 6 veya ustuyse UiAutomator2 kullanilir
        // Eger ki kullandigimiz android surumu 6 veya ustuyse UiAutomator2 kullanilir
        //MobileCapabilityType.APP ile bir APK'yı (uygulama) cep telefonuna yükleriz.
        //capabilities.setCapability(MobileCapabilityType.APP,"C:\\Users\\hasba\\IdeaProjects\\Appium_T-113\\Apps\\Calculator_8.4.1 (520193683)_Apkpure.apk");
        // app capabilityType bir uygulamayi yuklemek istedigimizde indirdigimiz apk dosyasinin path uzantisini vererek o uygulamayi yuklemek icin kullandigimiz desiredCapability
        //capabilities.setCapability("appPackage","com.google.android.calculator");
        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //Bir uygulamayı ilk defa yüklüyorsak yukarıdaki desiredcapability'i kullanacağız. Eğer zaten yüklüyse
        // uygulamanın aağıdaki gibi, bundleld kimliğini aşağıdaki şekilde çalıştırmamız yeterli oluyor.

        driver.activateApp("com.google.android.calculator");
        // uygulamanin yuklendigini dogrular(isInstalled)
        //driver.isAppInstalled("com.google.android.calculator");
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        // uygulamanin acildigini dogrular
        AndroidElement acButonu=driver.findElementByAccessibilityId("clear");
        Assert.assertTrue(acButonu.isDisplayed());
        // carpma,bolme,toplama,cikarma islemleri yaparak sonuclari dogrular
        driver.findElementByAccessibilityId("8").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("2").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("equals").click();
        String sonuc = driver.findElementById("com.google.android.calculator:id/result_final").getText();
        System.out.println(sonuc);
        Assert.assertEquals(Integer.parseInt(sonuc),1600);


        // AC butonuna tiklayarak ana ekrani temizler

    }
}
