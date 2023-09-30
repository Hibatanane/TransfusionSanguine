package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Entities.Personnel;
import iga.TransfusionSanguine.Entities.Rdv;
import iga.TransfusionSanguine.Repositories.PersonneRepository;
import iga.TransfusionSanguine.Repositories.PersonnelRepository;
import iga.TransfusionSanguine.Repositories.RdvRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Donneur")
public class DonneurController {
    @Autowired
    private RdvRepository rdvRepository;

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
        return "Donneur/rdv";
    }

    @PostMapping("/rdv")
    public String prendreRdv() {
        System.out.println("Execution post rdv");
        return "Donneur/rdv";
    }




}
