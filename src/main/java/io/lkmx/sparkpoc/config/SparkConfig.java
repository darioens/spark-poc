package io.lkmx.sparkpoc.config;


import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class SparkConfig {
    @Value("${spark.app.name}")
    private String appName;

    @Value("${spark.master}")
    private String masterUri;



    @Bean
    public Properties jdbcProperties() {
        Properties properties = new Properties();
        properties.setProperty("driver", "com.mysql.jdbc.Driver");
        properties.setProperty("user", "root");
        properties.setProperty("password", "password");
        return properties;
    }


}
