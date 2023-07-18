package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
//Buradaki method sayesinde Con.Read., conf.prop.'a gidecek, Driver s.40'daki platform adının Android olup olmadığını
    static {//kontrol edecek. Eğer değilse, s.40'taki if bloğu değil else bloğu çalışacak ve geçersiz platform name
        String path="configuration.properties";//diyecek.
        try {
            FileInputStream fileInputStream=new FileInputStream(path);
            properties=new Properties();
            properties.load(fileInputStream);
            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}
