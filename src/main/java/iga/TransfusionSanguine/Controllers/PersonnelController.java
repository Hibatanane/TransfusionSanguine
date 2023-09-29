package iga.TransfusionSanguine.Controllers;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Helpers.HTML;
import iga.TransfusionSanguine.Helpers.Token;
import iga.TransfusionSanguine.Repositories.PersonneRepository;
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
    @GetMapping("/acceuil")
    public String getAcceuil(Model model, HttpSession session)
    {
        return "Personnel/acceuil";
    }






}
