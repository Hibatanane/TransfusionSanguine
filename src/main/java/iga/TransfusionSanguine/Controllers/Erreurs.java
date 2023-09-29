package iga.TransfusionSanguine.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class Erreurs
{
    @GetMapping("/erreur403")
    public String getError403(Model model) {
        model.addAttribute("erreurMessage", "Accés interdit.");
        model.addAttribute("erreur403", true);

        return "erreur";
    }
}

