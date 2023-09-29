package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Repositories.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
@AllArgsConstructor

public class PersonneController {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private DonneurRepository donneurRepository;
    @Autowired
    private ReceveurRepository receveurRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ResponsableRepository responsableRepository;


    //Récuperer les villes a partir du fichier csv
    public List<String> initCities() throws IOException {
        List<String> cities = new ArrayList<>();
        try (InputStream is = getClass().getResourceAsStream("/citiesMa.csv"); BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
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

    @PostMapping("/inscription")
    public ModelAndView register(@Valid @ModelAttribute("registerUser") Personne personne) throws IOException {
        ModelAndView registrationPage = new ModelAndView("register");
        List<String> cities = initCities();
        String ok = personneRepository.isEmailExist(personne.getMail());
        if (ok != null) {
            registrationPage.addObject("errormail", "ce mail existe déjà");
            registrationPage.addObject("cities", cities);
            return registrationPage;
        }
        if (personne.getMdp().length() < 8) {
            registrationPage.addObject("cities", cities);
            registrationPage.addObject("errormdp", "Le mot de passe doit contenir au moins 8 caractères");
            return registrationPage;
        }
        //hash password
        String bmdp = BCrypt.hashpw(personne.getMdp(), BCrypt.gensalt());
        //register user
        personneRepository.registerUser(personne.getNomP(), personne.getPrenom(), personne.getMail(), bmdp, personne.getAdresseP(), personne.getDateP(), personne.getLatitude(), personne.getLongitude(), personne.getNum(), personne.getSexe(), personne.getVille(), personne.getTypePersonne(), false,false,false);
     if(personne.getTypePersonne().equals("Receveur"))
     {

     }
        registrationPage.addObject("success", "Votre compte est crée.");
        //Remplir le champs des villes :
        registrationPage.addObject("cities", cities);
        return registrationPage;
    }

}

