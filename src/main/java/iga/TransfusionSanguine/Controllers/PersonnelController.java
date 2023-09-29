package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Entities.Personnel;
import iga.TransfusionSanguine.Helpers.HTML;
import iga.TransfusionSanguine.Helpers.Token;
import iga.TransfusionSanguine.Repositories.PersonneRepository;
import iga.TransfusionSanguine.Repositories.PersonnelRepository;
import iga.TransfusionSanguine.Sender.MailSender;
import jakarta.mail.MessagingException;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
@RequestMapping("/Personnel")
public class PersonnelController {

    @Autowired
    private PersonneRepository personneRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @PostMapping("/ajouterPersonnel")
    public ModelAndView ajouterPersonnel(@Valid @ModelAttribute("addpersonnel") Personne personne) {
        ModelAndView personnelPage = new ModelAndView("Admin/personnel");
        if (personneRepository.isEmailExist(personne.getMail())) {
            personnelPage.addObject("errormail", "ce mail existe déjà");
            return personnelPage;
        }
        if (personne.getMdp().length() < 8) {
            personnelPage.addObject("errormdp", "Le mot de passe doit contenir au moins 8 caractères");
            return personnelPage;
        }
        String bmdp = BCrypt.hashpw(personne.getMdp(), BCrypt.gensalt());
        personneRepository.registerUser(personne.getNomP(), personne.getPrenom(), personne.getMail(), bmdp, personne.getAdresseP(), personne.getDateP(), (double) 0, (double) 0, personne.getNum(), personne.getSexe(), personne.getVille(),null,null, true, false, false);
        Personnel personnel = new Personnel();
        personnel.setIdPersonne(personne.getIdPersonne());
        personnel.setPoste(personnel.getPoste());
        personnelRepository.save(personnel);
        personnelPage.addObject("success", "Votre compte est crée.");

        return personnelPage;
    }




}
