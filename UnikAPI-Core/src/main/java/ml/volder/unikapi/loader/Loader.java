package ml.volder.unikapi.loader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import ml.volder.unikapi.UnikAPI;
import ml.volder.unikapi.keysystem.Key;
import ml.volder.unikapi.keysystem.KeyMapper;
import ml.volder.unikapi.keysystem.MouseButton;
import ml.volder.unikapi.logger.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Method;

public class Loader {

    public static void onEnable(InputStream loaderInfoStream) {
        UnikAPI.LOGGER.info("[UnikAPI-Core] Enabling addon!");
        if(loaderInfoStream == null){
            UnikAPI.LOGGER.warning("Kunne ikke finde loaderInfo.json - Kunne ikke aktivere dit addon!");
            return;
        }

        String content = getStringByInputStream(loaderInfoStream);
        if(content == null || content.length() <= 0){
            UnikAPI.LOGGER.warning("Kunne ikke finde noget data i loaderInfo.json - Kunne ikke aktivere dit addon!");
            return;
        }
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject)parser.parse(content);

        if(!jsonObject.has("mainClass")) {
            UnikAPI.LOGGER.warning("Kunne ikke finde mainClass i loaderInfo.json - Kunne ikke aktivere dit addon!");
            return;
        }

        String mainClass = jsonObject.get("mainClass").getAsString();

        if(mainClass == null || mainClass.length() <= 0) {
            UnikAPI.LOGGER.warning("Kunne ikke finde mainClass i loaderInfo.json - Kunne ikke aktivere dit addon!");
            return;
        }
        initializeKeySystem();
        enableAddon(mainClass);
    }

    public static void onEnable() {
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("transporter/loaderInfo.json");
        if(inputStream == null){
            UnikAPI.LOGGER.warning("Kunne ikke finde loaderInfo.json - Kunne ikke aktivere dit addon!");
            return;
        }
        onEnable(inputStream);
    }

    private static void initializeKeySystem() {
        Key.initialize();
        MouseButton.initialize();
    }

    private static void enableAddon(String mainClass) {
        try {
            Class klass = Class.forName(mainClass);
            Object instance = klass.newInstance();
            Method method = klass.getDeclaredMethod("onEnable", null);
            method.invoke(instance, null);
        } catch (Exception e) {
            UnikAPI.LOGGER.printStackTrace(Logger.LOG_LEVEL.SEVERE, e);
            UnikAPI.LOGGER.warning("Kunne ikke aktivere addonet!");
        }
    }

    private static String getStringByInputStream(InputStream inputStream) {
        StringBuilder stringBuilder = new StringBuilder();
        int character;
        try {
            while((character = inputStream.read()) != -1) {
                stringBuilder.append((char)character);
            }
        } catch (IOException e) {
            UnikAPI.LOGGER.printStackTrace(Logger.LOG_LEVEL.INFO, e);
        }
        return stringBuilder.toString();
    }
}
