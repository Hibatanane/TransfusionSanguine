package iga.TransfusionSanguine.Config;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Properties;

//Cette classe est pour configurer notre messagerie

@CrossOrigin("*")
public class MailConfig {
    public static JavaMailSenderImpl getMailConfig() {
        JavaMailSenderImpl emailConfig = new JavaMailSenderImpl();

        Properties props = emailConfig.getJavaMailProperties();
        props.put("mail.transport.protocol","smtp");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.starttls.required","true");
        props.put("mail.debug","true");
        props.put("mail.smtp.ssl.enable","true");


        emailConfig.setHost("smtp.gmail.com");
        emailConfig.setPort(465);
        emailConfig.setUsername("hiba.tanane@etud.iga.ac.ma");
        emailConfig.setPassword("redbtlfmssaocnnb");
        return emailConfig; }
}
