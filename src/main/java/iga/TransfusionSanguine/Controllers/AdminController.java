package iga.TransfusionSanguine.Controllers;


import iga.TransfusionSanguine.Entities.Centre;
import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Entities.Personnel;
import iga.TransfusionSanguine.Entities.Responsable;
import iga.TransfusionSanguine.Repositories.CentreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/Admin")
public class AdminController {

    @Autowired
    private CentreRepository centreRepository;
@GetMapping("/acceuil")
public String getAcceuil()
{
    return "Admin/acceuil";
}
    @GetMapping("/centre")
    public String getIndex(Model model){
        model.addAttribute("Addcentre",new Centre());
        return "Admin/centre";
    }

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

    @GetMapping("/responsable")
    public ModelAndView getResponsable(@ModelAttribute("addresponsable")Responsable responsable) throws IOException {
        ModelAndView getRegisterPage = new ModelAndView("Admin/responsable");
        List<String> cities = initCities();
        getRegisterPage.addObject("cities", cities);
        return getRegisterPage;
    }

    @GetMapping("/personnel")
    public ModelAndView getPersonnel(@ModelAttribute("addpersonnel") Personnel personnel, Model model) throws IOException {
        ModelAndView getRegisterPage = new ModelAndView("Admin/personnel");
        List<String> cities = initCities();
        getRegisterPage.addObject("cities", cities);
        model.addAttribute("centres", centreRepository.findAll());
        return getRegisterPage;
    }


}
