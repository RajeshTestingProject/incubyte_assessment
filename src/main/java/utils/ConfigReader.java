package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;
    public Properties init_prop() {

        properties = new Properties();
        try {
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
            properties.load(ip);
        } catch (Throwable t) {
            System.out.println(t.getMessage());
        }
        return properties;
    }
    // Method to get the URL from the properties file
    public String getFirstname() {

        return properties.getProperty("account.firstname");
    }

    // Method to get the email
    public String getLastname() {
        return properties.getProperty("account.lastname");
    }

    // Method to get the URL from the properties file
    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    // Method to get the email
    public String getEmail() {
        return properties.getProperty("user.email");
    }

    // Method to get the password
    public String getPassword() {
        return properties.getProperty("user.password");
    }

    // Method to get WebDriver path
    public String getWebDriverPath() {
        return properties.getProperty("webdriver.chrome.driver");
    }
}

