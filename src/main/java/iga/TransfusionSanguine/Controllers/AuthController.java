package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Helpers.HTML;
import iga.TransfusionSanguine.Helpers.Token;
import iga.TransfusionSanguine.Sender.MailSender;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@CrossOrigin("*")

public class AuthController
{
    @GetMapping("/connexion")
    public ModelAndView getLogin(){
        ModelAndView getLoginPage = new ModelAndView("login");
//        String token = Token.generateToken();
//        getLoginPage.addObject("token",token);
        getLoginPage.addObject("PageTitle","connexion");
        System.out.println("page de connexion");
        return  getLoginPage;
    }
    @PostMapping("/connexion")
    public ModelAndView verifyLogin(){
        ModelAndView getLoginPage =  new ModelAndView("login");


        return  getLoginPage;
    }
    //Récuperer les villes a partir du fichier csv
    public List<String> initCities() throws IOException {
        List<String> cities = new ArrayList<>();
        try (InputStream is = getClass().getResourceAsStream("/citiesMa.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String name = data[0];
                cities.add(name);
            }
        }
        return cities;
    }

    @GetMapping("/inscription")
    public ModelAndView getRegister() throws IOException {
        ModelAndView getRegisterPage = new ModelAndView("register");
        System.out.println("page d'inscription");
        List<String> cities = initCities();
        getRegisterPage.addObject("cities", cities);
        return getRegisterPage;
    }

}

