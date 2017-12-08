package com.saltedfish.demogradleservice.common;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Calendar;
import java.util.ResourceBundle;

/**
 * Created by pengchongchong on 17-12-8.
 */
@Component
public class Constants {
    public static String name = "rose";

    public static ResourceBundle rb = ResourceBundle.getBundle("configs");
    private static long _lastModified = new File(Constants.class.getResource("/").getPath() + "config.properties").lastModified();
    private static int _lastCheckMinute = Calendar.getInstance().get(Calendar.MINUTE);
    public static int getIntFromConfig(String key){
        tryReLode();
        return Integer.parseInt(rb.getString(key));
    }
    public static String getStringFromConfig(String key) {
        tryReLode();
        return rb.getString(key);
    }
    private static void tryReLode() {
        if (_lastCheckMinute == Calendar.getInstance().get(Calendar.MINUTE)) {
            return;
        }
        _lastCheckMinute = Calendar.getInstance().get(Calendar.MINUTE);

        File file = new File(Constants.class.getResource("/").getPath() + "config.properties");
        long newLastModified = file.lastModified();
        if (_lastModified != newLastModified) {
            ResourceBundle.clearCache();
            rb = ResourceBundle.getBundle("config");
            _lastModified = newLastModified;
        }
    }

    public static void main(String[] args) {
        System.out.println(Constants.class.getResource("/").getPath()+"configs.properties");
    }


}
