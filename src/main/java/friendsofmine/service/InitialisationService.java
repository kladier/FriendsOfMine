package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class InitialisationService {

    @Autowired
    private ActiviteService activiteService;

    private Utilisateur thom, mary;
    private Activite randonnee, lindyhop, taekwondo;

    public void initDonnees() {
        initMary();
        initThom();
        initRandonnee();
        initLindyHop();
        initTaekwondo();
    }

    private void initThom() {
        thom = new Utilisateur("Thom", "Thom", "thom@thom.com", "M");
    }

    private void initMary() {
        mary = new Utilisateur("Mary", "Mary", "mary@mary.com", "F");
    }

    private void initTaekwondo() {
        taekwondo = new Activite("Taekwondo", "le dimanche soir", thom);
        activiteService.saveActivite(taekwondo);

    }

    private void initLindyHop() {
        lindyhop = new Activite("Lindy Hop", "le jeudi soir", thom);
        activiteService.saveActivite(lindyhop);
    }

    private void initRandonnee() {
        randonnee = new Activite("Randonnee", "le lundi matin", mary);
        activiteService.saveActivite(randonnee);
    }

    public Utilisateur getThom() {
        return thom;
    }

    public Utilisateur getMary() {
        return mary;
    }

    public Activite getRandonnee() {
        return randonnee;
    }

    public Activite getLindyhop() {
        return lindyhop;
    }

    public Activite getTaekwondo() {
        return taekwondo;
    }
}