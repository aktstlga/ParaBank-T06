package Utilities;

import net.datafaker.Faker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Locale;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties = new Properties();
    static Faker dataFaker = new Faker(new Locale("en-US"));

    static {
        try {
            FileInputStream file = new FileInputStream("src/configuration.properties");
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
    public static void updateProperty(String keyword) {

        switch (keyword) {
            case "username":
                String name = dataFaker.name().username();
                properties.setProperty(keyword, name);
                break;
            case "password":
                String password = dataFaker.internet().password();
                properties.setProperty(keyword, password);
                break;
        }

        FileOutputStream outputFile = null;
        try {
            outputFile = new FileOutputStream("src/configuration.properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            properties.store(outputFile, null);
            outputFile.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}