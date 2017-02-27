package friendsofmine.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import friendsofmine.services.InitialisationService;

/**
 * Created by what on 27/02/17.
 */
@Controller
public class UtilisateurController {
    @Autowired
    private InitialisationService initialisationService;

    @RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("utilisateurs", initialisationService.getListUtilisateur());
        return "utilisateurs";
    }
}