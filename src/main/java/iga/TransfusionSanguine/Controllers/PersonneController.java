package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Donneur;
import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Entities.Receveur;
import iga.TransfusionSanguine.Repositories.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        Personne ok = personneRepository.findByMail(personne.getMail());
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

        if (personne.getTypePersonne().equals("Receveur") || personne.getTypePersonne().equals("receveur")) {

            Receveur x = new Receveur();
            x.setNomP(personne.getNomP());
            x.setPrenom(personne.getPrenom());
            x.setTypePersonne(personne.getTypePersonne());
            x.setVille(personne.getVille());
            x.setAdresseP(personne.getAdresseP());
            x.setEstAdmin(false);
            x.setEstPersonnel(false);
            x.setEstResponsable(false);
            x.setEnUrgence(false);
            x.setGroupe(personne.getGroupe());
            x.setMail(personne.getMail());
            x.setDateP(personne.getDateP());
            x.setIdPersonne(personne.getIdPersonne());
            x.setNum(personne.getNum());
            x.setLatitude(personne.getLatitude());
            x.setLongitude(personne.getLongitude());
            x.setMdp(bmdp);
            receveurRepository.save(x);
        } else {
            Donneur x = new Donneur();
            x.setNomP(personne.getNomP());
            x.setPrenom(personne.getPrenom());
            x.setTypePersonne(personne.getTypePersonne());
            x.setVille(personne.getVille());
            x.setAdresseP(personne.getAdresseP());
            x.setEstAdmin(false);
            x.setEstPersonnel(false);
            x.setEstResponsable(false);
            x.setGroupe(personne.getGroupe());
            x.setMail(personne.getMail());
            x.setDateP(personne.getDateP());
            x.setIdPersonne(personne.getIdPersonne());
            x.setNum(personne.getNum());
            x.setLatitude(personne.getLatitude());
            x.setLongitude(personne.getLongitude());
            x.setMdp(bmdp);
            donneurRepository.save(x);
        }
        registrationPage.addObject("success", "Votre compte est crée.");
        //Remplir le champs des villes :
        registrationPage.addObject("cities", cities);
        return registrationPage;
    }

}

