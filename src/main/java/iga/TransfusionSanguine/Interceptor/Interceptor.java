package iga.TransfusionSanguine.Interceptor;

import iga.TransfusionSanguine.Entities.Personne;
import iga.TransfusionSanguine.Repositories.PersonneRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class Interceptor implements HandlerInterceptor {
    @Autowired
    private PersonneRepository personneRepository;

    //Si l'utilisateur demande une page qui est interdite.
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        // Vérification si l'utilisateur est déja connecté
        if (email == null) {
            // Redirection vers la page d'erreur 403
            response.sendRedirect("/erreur403");
            return false;
        }

        Personne personne = personneRepository.findByMail(email);
        request.setAttribute("personne", personne); // Ajout de l'objet Utilisateur à l'objet Model
        return true;


    }

    private boolean isAdmin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Personne personne = personneRepository.findByMail(email);
        if (personne.isEstAdmin() == true) {
            return true;
        }
        return false;
    }

    private boolean isRespo(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Personne personne = personneRepository.findByMail(email);
        return personne.isEstResponsable();
    }

    private boolean isPersonnel(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Personne personne = personneRepository.findByMail(email);
        return personne.isEstPersonnel();
    }

    private boolean isReceveur(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Personne personne = personneRepository.findByMail(email);
        return personne.getTypePersonne().equals("Receveur") || personne.getTypePersonne().equals("receveur");
    }

    private boolean isDonneur(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Personne personne = personneRepository.findByMail(email);
        return personne.getTypePersonne().equals("Donneur") || personne.getTypePersonne().equals("donneur");
    }

    //Pour récuperer session on fait : Utilisateur utilisateur = (Utilisateur) request.getAttribute("utilisateur")
    // --> "utilisateur" c'est le attributName qu'on a affecté dans le modele
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        // Recuper l'utilisateur a partir d'email
        Personne personne = personneRepository.findByMail(email);
        System.out.println("Personne postHandle : "+personne.getIdPersonne());
        // Ajouter l'email à l'objet Model
        if (modelAndView != null && personne != null) {
            modelAndView.addObject("personne", personne);
        }
    }

}
