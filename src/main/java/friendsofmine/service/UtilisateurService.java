package friendsofmine.service;

import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
}
