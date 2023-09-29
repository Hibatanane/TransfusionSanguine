package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Entities.Rdv;
import iga.TransfusionSanguine.Repositories.RdvRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Donneur")
public class DonneurController
{
    @Autowired
    private RdvRepository rdvRepository;

    @GetMapping("/acceuil")
    public String getAcceuil(Model model)
    {
        return "Donneur/acceuil";
    }

    @GetMapping("/rdv")
    public ModelAndView listeRdv(Model model, HttpServletRequest request ) {
        ModelAndView getRegisterPage = new ModelAndView("Donneur/rdv");
        Personne personne = (Personne) request.getAttribute("personne");
        System.out.println("Id personne dans donneur controller"+personne.getIdPersonne());
            long idDonneur = personne.getIdPersonne();
            List<Rdv> listeRdv = new ArrayList<>();
            listeRdv=rdvRepository.findRdvByIdDonneur(idDonneur);
        getRegisterPage.addObject("tailleListeRdv",listeRdv.size());
        getRegisterPage.addObject("listeRdv", listeRdv);
            return getRegisterPage;
    }
    @PostMapping("/rdv")
    public String prendreRdv()
    {
        return "Donneur/rdv";
    }
}
