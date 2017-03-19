package friendsofmine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import friendsofmine.service.InitialisationService;
import javax.annotation.PostConstruct;

/**
 * Created by what on 27/02/17.
 */
@Component
public class Bootstrap {
    @Autowired
    private InitialisationService initialisationService;

    @PostConstruct
    public void init() {
        initialisationService.initDonnees();
    }

    public InitialisationService getInitialisationService() {
        return initialisationService;
    }
}
