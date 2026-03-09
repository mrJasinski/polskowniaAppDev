package com.polskowniaApp;

import com.polskowniaApp.utils.DataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableConfigurationProperties(DataSourceConfig.class)
public class Main
{
    public static void main(String[] args)
    {
        SpringApplication.run(Main.class, args);
    }
}