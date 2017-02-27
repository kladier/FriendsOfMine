package friendsofmine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by what on 27/02/17.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index (){
        return "index";
    }
}
