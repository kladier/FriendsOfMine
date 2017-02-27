package friendsofmine;

import org.springframework.stereotype.Component;
import service.InitialisationService;

import javax.annotation.PostConstruct;

/**
 * Created by what on 27/02/17.
 */
@Component
public class Bootstrap {
    private InitialisationService initService;

    @PostConstruct
    public void init() {
        initService.initDonnees();
    }
}
