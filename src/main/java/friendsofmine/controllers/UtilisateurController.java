package friendsofmine.controllers;

import friendsofmine.domain.Utilisateur;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by what on 27/02/17.
 */
@Controller
public class UtilisateurController {
    @Autowired
    private UtilisateurService utilisateurService;

    @RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("utilisateurs", utilisateurService.findAllUtilisateurs());
        return "utilisateurs";
    }

    @RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
    public String show(Model model, @PathVariable("id") Long id) {
        if (utilisateurService.findOneUtilisateur(id)!=null) {
            model.addAttribute("utilisateur", utilisateurService.findOneUtilisateur(id));
            return "utilisateurShow";
        }
        else {
            model.addAttribute("customMessage", "L'utilisateur n'existe pas");
            return "error";
        }

    }

    @RequestMapping(value = "/utilisateur/new", method = RequestMethod.GET)
    public String createForm(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "utilisateurForm";
    }

    @RequestMapping(value = "/utilisateur", method = RequestMethod.POST)
    public String create(@Valid Utilisateur utilisateur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "utilisateurForm";
        }
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateur/"+utilisateur.getId();
    }
}