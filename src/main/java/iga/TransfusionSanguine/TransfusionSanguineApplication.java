package iga.TransfusionSanguine;

import iga.TransfusionSanguine.Entities.Receveur;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication
public class TransfusionSanguineApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransfusionSanguineApplication.class, args);
        System.out.println("Application Transfusion Sanguine");


    }


}
