package friendsofmine.controllers;

import friendsofmine.service.ActiviteService;
import friendsofmine.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}