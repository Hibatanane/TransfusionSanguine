package iga.TransfusionSanguine.controller_advisor;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Entities.Rdv;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
@ControllerAdvice

public class AdvisorController
{
    @ModelAttribute("registerUser")
    public Personne getUserDefaults(){

        return new Personne();
    }
    @ModelAttribute("Rdv")
    public Rdv getRdvDefaults()
    {
        return new Rdv();
    }
}
