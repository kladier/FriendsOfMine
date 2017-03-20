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
    public String create(Model model, @Valid Utilisateur utilisateur, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "utilisateurForm";
        }
        utilisateurService.saveUtilisateur(utilisateur);
        return "redirect:/utilisateur/"+utilisateur.getId();
    }

    @RequestMapping(value = "/utilisateur/edit/{id}", method = RequestMethod.GET)
    public String editForm(Model model, @PathVariable("id") Long id) {
        if (utilisateurService.findOneUtilisateur(id)!=null) {
            model.addAttribute("utilisateur", utilisateurService.findOneUtilisateur(id));
            return "utilisateurForm";
        }
        else {
            model.addAttribute("customMessage", "L'utilisateur n'existe pas.");
            return "error";
        }
    }

    @RequestMapping(value = "/utilisateur/delete/{id}", method = RequestMethod.DELETE)
    public String delete(Model model, @PathVariable("id") Long id) {
        Utilisateur user = utilisateurService.findOneUtilisateur(id);

        if (user == null) {
            model.addAttribute("customMessage", "L'utilisateur n'existe pas.");
            return "error";
        }
        if (!user.getActivites().isEmpty()) {
            model.addAttribute("customMessage", "Impossible. L&#39;utilisateur est responsable d&#39;activités");
            return "error";
        }
        utilisateurService.deleteUtilisateur(user.getId());
        return "redirect:/utilisateurs";
    }
}