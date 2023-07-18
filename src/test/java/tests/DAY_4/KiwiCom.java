package tests.DAY_4;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.KiwiPage;
import utils.Driver;

public class KiwiCom {
    AndroidDriver<AndroidElement>driver=Driver.getAndroidDriver();
    KiwiPage kiwi = new KiwiPage();//Artık KiwiPage'de oluşturulan public değerleri burada obje oluşturarak kullanabiliriz.
    TouchAction touchAction=new TouchAction<>(driver);
    // uygulamanin yuklendigi dogrulanir
    // uygulamanin basariyla acildigi dogrulanir
    // misafir olarak devam et e tiklanir
    // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
    // Trip type,one way olarak secilir
    // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
    // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
    // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
    // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
    // search butonuna tiklanir
    // en  ucuz ve aktarmasiz filtrelemeleri yapilir
    // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir

    @Test
    public void kiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
        // uygulamanin basariyla acildigi dogrulanir
        //AndroidElement guest = driver.findElementByXPath("//*[@text='Continue as a guest']");
        //Assert.assertTrue(guest.isDisplayed()); //I. alternatif
        Assert.assertTrue(kiwi.misafir.isDisplayed());//II. alternatif
        // misafir olarak devam et e tiklanir
        //guest.click();I.alternatif
        kiwi.misafir.click();//II. alternatif
        // ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir
        //538,1686
        Thread.sleep(1000);
       kiwi.ucAdimGecme(0,3,538,1686,1000);
        // Trip type,one way olarak secilir
        Thread.sleep(2000);
        kiwi.koordinatTiklama(290,627,1000);
        Thread.sleep(2000);
        kiwi.koordinatTiklama(552,1448,1000);
        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        kiwi.koordinatTiklama(502,780,1000);
        kiwi.koordinatTiklama(1016,135,1000);
        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Kayseri");
        } else {
            kiwi.departureBox.sendKeys("Atina");
        }
        Thread.sleep(1000);
        kiwi.koordinatTiklama(493,294,1000);

        kiwi.chooseButton.click();
        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        kiwi.koordinatTiklama(431,906,1000);

        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Singapur");
        } else {
            kiwi.departureBox.sendKeys("Papua Yeni Gine");
        }
        Thread.sleep(1000);
        kiwi.koordinatTiklama(493,294,1000);

        kiwi.chooseButton.click();
        // gidis tarihi mayis ayinin 21 i olarak secilir ve set date e tiklanir
        // search butonuna tiklanir
        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    }

}
