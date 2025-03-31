package hu.cepl.casemanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CaseManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaseManagerApplication.class, args);
    }

}
