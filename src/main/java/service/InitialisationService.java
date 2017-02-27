package service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import org.apache.tomcat.util.modeler.Util;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by what on 27/02/17.
 */
@Service
public class InitialisationService {
    private ArrayList<Activite> listActivite;
    private ArrayList<Utilisateur> listUtilisateur;

    public void initDonnees() {
        this.listActivite = new ArrayList<Activite>();
        this.listUtilisateur = new ArrayList<Utilisateur>();

        listActivite.add(new Activite("Activité 1", "Voici l'activité 1"));
        listActivite.add(new Activite("Activité 2", "Voici l'activité 2"));
        listActivite.add(new Activite("Activité 3", "Voici l'activité 3"));

        listUtilisateur.add(new Utilisateur("Dupont", "Jean", "jean@dupont.fr", "M"));
        listUtilisateur.add(new Utilisateur("Durand", "Jacques", "jack@durant.fr", "M"));
        listUtilisateur.add(new Utilisateur("Igne", "Marie", "marie@igne.fr", "F"));
    }
}
