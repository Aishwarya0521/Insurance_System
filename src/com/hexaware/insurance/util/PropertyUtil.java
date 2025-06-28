package com.hexaware.insurance.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

    public static String getPropertyString() {
        Properties props = new Properties();
        try (InputStream input = PropertyUtil.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find db.properties");
                return null;
            }

            props.load(input);

            String host = props.getProperty("host");
            String port = props.getProperty("port");
            String dbname = props.getProperty("dbname");
            String username = props.getProperty("username");
            String password = props.getProperty("password");

            return "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?user=" + username + "&password=" + password;

        } catch (Exception e) {
            System.out.println("Error loading db.properties: " + e.getMessage());
            return null;
        }
    }
}
