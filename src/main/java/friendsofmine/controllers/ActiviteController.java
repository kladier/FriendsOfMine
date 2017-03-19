package friendsofmine.controllers;

import friendsofmine.service.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by what on 27/02/17.
 */
@Controller
public class ActiviteController {
    @Autowired
    private ActiviteService activiteService;

    @RequestMapping(value = "/activites", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("activites", activiteService.findAllActivites());
        return "activites";
    }
}