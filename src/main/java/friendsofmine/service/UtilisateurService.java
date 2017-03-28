package friendsofmine.service;

import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by what on 07/03/17.
 */
@Service
public class UtilisateurService {
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public void setUtilisateurRepository(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public void saveUtilisateur(Utilisateur user) {
        utilisateurRepository.save(user);
    }

    public Utilisateur findOneUtilisateur(Long id) {
        return this.utilisateurRepository.findOne(id);
    }

    public long countUtilisateur() {
        return this.utilisateurRepository.count();
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }

    public ArrayList<Utilisateur> findAllUtilisateurs() {
        Iterable<Utilisateur> utilisateurs = utilisateurRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC,"nom")));
        ArrayList<Utilisateur> utilisateurList = new ArrayList<>();
        utilisateurs.forEach(utilisateurList::add);
        return utilisateurList;
    }

    public void deleteUtilisateur(Long id) {
        utilisateurRepository.delete(id);
    }

    private ArrayList<Utilisateur> convert(Iterable<Utilisateur> utilisateurs) {
        ArrayList<Utilisateur> utilisateurList = new ArrayList<>();
        utilisateurs.forEach(utilisateurList::add);
        return utilisateurList;
    }

    public ArrayList<Utilisateur> findUtilisateursM() {
        Utilisateur homme = new Utilisateur();
        homme.setSexe("M");
        Example<Utilisateur> example = Example.of(homme);

        return convert(utilisateurRepository.findAll(example));
    }

    public ArrayList<Utilisateur> findUtilisateursF() {
        Utilisateur femme = new Utilisateur();
        femme.setSexe("F");
        Example<Utilisateur> example = Example.of(femme);

        return convert(utilisateurRepository.findAll(example));
    }
}
