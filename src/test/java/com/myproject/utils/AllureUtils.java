package com.myproject.utils;


import io.qameta.allure.Allure;
import java.io.ByteArrayInputStream;

public class AllureUtils {

    public static void attachText(String title, String message) {
        Allure.addAttachment(title, message);
    }

    public static void attachScreenshot(String title, byte[] screenshot) {
        Allure.addAttachment(title, new ByteArrayInputStream(screenshot));
    }

}
