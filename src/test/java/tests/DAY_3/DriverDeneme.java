package tests.DAY_3;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import utils.Driver;

public class DriverDeneme {
    AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();//Eşitliğin sağ tarafı, Driver class'ında
//hangi uygulamanın kimliğini belirtmişsek onu çalıştıracak. (Driver Class'ında appPackage ve appActivity değerleri değiştirilerek)
    @Test
    public void test01(){
        System.out.println(driver.getDeviceTime());//Buradaki driver çalışınca Driver class'ında belirlenen app çalışacak.
    }
}
