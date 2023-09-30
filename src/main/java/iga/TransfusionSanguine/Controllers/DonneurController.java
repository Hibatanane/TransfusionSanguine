package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.*;
import iga.TransfusionSanguine.Repositories.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Donneur")
public class DonneurController {
    @Autowired
    private RdvRepository rdvRepository;
    @Autowired
    private DonneurRepository donneurRepository;
    @Autowired
    private DonRepository donRepository;

    @GetMapping("/acceuil")
    public String getAcceuil(Model model) {
        return "Donneur/acceuil";
    }

    @GetMapping("/rdv")
    public String listeRdv(Model model, HttpServletRequest request) {
        Personne personne = (Personne) request.getAttribute("personne");
        long idDonneur = personne.getIdPersonne();
        List<Rdv> listeRdv = new ArrayList<>();
        listeRdv = rdvRepository.findRdvByIdDonneur(idDonneur);
        model.addAttribute("tailleListeRdv", listeRdv.size());
        model.addAttribute("listeRdv", listeRdv);
        model.addAttribute("newRdv", new Rdv());
        System.out.println("Execution get mapp de rdv");
        return "Donneur/rdv";
    }

    @PostMapping("/rdv")
    public String prendreRdv(@RequestParam("dateRdv") LocalDate dateRdv,
                             @RequestParam("heureRdv") LocalTime heureRdv,
                             HttpServletRequest request,
                             Model model) {
        System.out.println("Methode post rdv");
        Personne personne = (Personne) request.getAttribute("personne");
        Rdv rdv = new Rdv();
        System.out.println("print : +"+personne.getIdPersonne());
        Donneur donneur = donneurRepository.findByIdPersonne(personne.getIdPersonne());
        System.out.println("donneur : "+donneur.getIdPersonne());
        rdv.setDonneurRdv(donneur);
        rdv.setDateRdv(dateRdv);
        rdv.setHeureRdv(heureRdv);
        rdv.setConfirmation("En attente");
        rdvRepository.save(rdv);
        model.addAttribute("message", "Rendez-vous créé avec succès");
        return "redirect:/Donneur/rdv";

    }

    @GetMapping("/don")
    public String afficherDon(Model model,
                              HttpServletRequest request)
    {
      Personne personne = (Personne) request.getAttribute("personne");
        List<Object[]> listeDon = donRepository.findDonDetailsByIdDonneur(personne.getIdPersonne());
        model.addAttribute("listeDon", listeDon);
        model.addAttribute("tailleListe", listeDon.size());
        return "Donneur/don";
    }
}
