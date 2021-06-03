package Utilities.ConfigUtlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataFactory {
    public File file;
    public FileInputStream fis;
    public static Properties Repository = new Properties();

    public ConfigDataFactory() throws IOException {
        file = new File(System.getProperty("usr.dir") + "/src/test/resources/config/config.properties");
        System.out.println(file);
        try {
            fis = new FileInputStream(file);
            Repository.load(fis);
        } catch (Exception e) {
            System.out.println("This path" + file + " does not have the configuration file" + e.getMessage());
        }
    }

    public String getDataFromConfig(String KeyToSearch) {
        return Repository.getProperty(KeyToSearch);
    }

    public String getBrowserConfig() {
        return Repository.getProperty("browser");
    }

    public String getURLConfig() {
        return Repository.getProperty("QA_url");
    }

    public String getEnvironment() {
        return Repository.getProperty("RunEnvironment");
    }

}
