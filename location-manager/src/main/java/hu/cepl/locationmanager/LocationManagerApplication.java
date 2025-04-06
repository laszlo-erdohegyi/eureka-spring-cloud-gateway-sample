package hu.cepl.locationmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class LocationManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LocationManagerApplication.class, args);
    }

}
