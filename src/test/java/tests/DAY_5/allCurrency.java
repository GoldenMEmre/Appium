package tests.DAY_5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrency;
import utils.Driver;
import utils.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class allCurrency {
    AndroidDriver<AndroidElement> driver = Driver.getAndroidDriver();
    AllCurrency currency=new AllCurrency();
    // all currency uygulamasinin yuklendigi dogulanir
    // uygulamanin acildigi dogrulanir
    // cevirmek istedigimiz para birimi zloty olarak secilir
    // cevirelecek olan para birimi Tl olarak secilir
    // cevrilen tutar screenShot olarak kaydedilir
    // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
    // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir

    @Test
    public void allCurrencyTest() throws InterruptedException, IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));
        // uygulamanin acildigi dogrulanir
        Assert.assertTrue(currency.currencyText.isDisplayed());
        // cevirmek istedigimiz para birimi zloty olarak secilir
        //496,347
        ReusableMethods.koordinatTiklama(496,347,1000);
        ReusableMethods.scrollWithUiScrollable("PLN");
        // cevirelecek olan para birimi Tl olarak secilir
        ReusableMethods.koordinatTiklama(500,492,1000);
        ReusableMethods.scrollWithUiScrollable("TRY");
        currency.bir.click();
        currency.sifir.click();
        currency.sifir.click();
        currency.sifir.click();
        // cevrilen tutar screenShot olarak kaydedilir
        /*
        File fileSS =driver.getScreenshotAs(OutputType.FILE);// ScreenShot i cekecek olan satir
        FileUtils.copyFile(fileSS,new File("zlotyToTL.jpg")); //FileUtils classindan bir kopya olustururak gormek istedigimiz degerin ismini path olarak girdigimiz onun kopyasini utilsden bizim icin olusturuyor
        */

        ReusableMethods.getScreenshot("zlotyToTl");
        // Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
        // bu islem dolar tl, sweden kron-tl, Japon yeni- tl olarak tekrarlanir ve kullaniciya sms olarak bildirilir
        String finalExchange=currency.sonucDegeri.getText();
        String number="5555555555";
        driver.sendSMS(number,finalExchange);



    }
}
