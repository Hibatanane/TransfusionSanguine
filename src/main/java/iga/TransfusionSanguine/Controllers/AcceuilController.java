package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Repositories.PersonneRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@NoArgsConstructor
@CrossOrigin("*")

public class AcceuilController {

    private PersonneRepository personneRepository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(Model model)
    {
        return "index";
    }



}
