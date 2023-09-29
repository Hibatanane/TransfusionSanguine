package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Helpers.HTML;
import iga.TransfusionSanguine.Helpers.Token;
import iga.TransfusionSanguine.Repositories.PersonneRepository;
import iga.TransfusionSanguine.Sender.MailSender;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

public class ConnexionController {
    @Autowired
    private PersonneRepository personneRepository;
    @Autowired
    private HttpSession httpSession;

    @GetMapping("/connexion")
    public ModelAndView getLogin() {
        ModelAndView getLoginPage = new ModelAndView("login");
        System.out.println("execution de getmapping connexion");
        getLoginPage.addObject("PageTitle", "connexion");
        System.out.println("page de connexion");
        return getLoginPage;
    }

    @PostMapping("/connexion")
    public String verifyLogin(@RequestParam("email") String email,
                              @RequestParam("mdp") String mdp,
                              RedirectAttributes redirectAttributes,
                              HttpSession session,
                              Model model) {

        System.out.println("execution de post mapping connexion");
        if (email.isEmpty() || mdp.isEmpty()) {
            model.addAttribute("error", "Vous devez remplir tous les champs");
            return "login";
        }
        Personne personne = personneRepository.findByMail(email);
        if (personne == null) {
            model.addAttribute("error", "Ce mail n'existe pas");
            return "login";
        }
        if (personne != null) {
            if (!BCrypt.checkpw(mdp, personne.getMdp())) {
                model.addAttribute("error", "Email ou Mot de passe incorrect");
                return "login";
            }

        } else {
            model.addAttribute("error", "une erreur s'est produite");
            return "login";
        }
        session.setAttribute("email", email);
        if (personne.getTypePersonne() != null)
        {
            if (personne.getTypePersonne().equals("Receveur") || personne.getTypePersonne().equals("receveur")) {
                return "redirect:/Receveur/acceuil";

            }
            if (personne.getTypePersonne().equals("Donneur") || personne.getTypePersonne().equals("donneur")) {
                return "redirect:/Donneur/acceuil";
            }

        } else {

            if (personne.isEstPersonnel() == true && personne.isEstAdmin()==false && personne.isEstResponsable()==false) {
                return "redirect:/Personnel/acceuil";

            }
            if (personne.isEstResponsable() == true && personne.isEstPersonnel() == false && personne.isEstAdmin()==false ) {
                return "redirect:/Responsable/acceuil";

            }
            if (personne.isEstAdmin() == true && personne.isEstPersonnel()==false && personne.isEstResponsable()==false) {
                return "redirect:/Admin/acceuil";

            }
        }
        return "erreur";


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

