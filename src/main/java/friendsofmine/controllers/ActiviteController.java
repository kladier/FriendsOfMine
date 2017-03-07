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
public class ActiviteController {
    @Autowired
    private InitialisationService initialisationService;

    public InitialisationService getInitialisationService() {
        return initialisationService;
    }

    @RequestMapping(value = "/activites", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("activites", initialisationService.getListActivite());
        return "activites";
    }

}