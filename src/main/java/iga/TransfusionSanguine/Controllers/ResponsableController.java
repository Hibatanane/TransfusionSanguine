package iga.TransfusionSanguine.Controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Responsable")
public class ResponsableController
{
    @GetMapping("/acceuil")
    public String getAcceuil(Model model, HttpSession session)
    {
        return "Responsable/acceuil";
    }
}
