package friendsofmine.service;

import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return 0;
    }

    public UtilisateurRepository getUtilisateurRepository() {
        return utilisateurRepository;
    }
}
