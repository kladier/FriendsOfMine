package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.repositories.ActiviteRepository;
import friendsofmine.repositories.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

/**
 * Created by what on 07/03/17.
 */
@Service
public class ActiviteService {
    @Autowired
    private ActiviteRepository activiteRepository;

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    public Activite saveActivite(Activite activite) {
        if (activite == null) {
            throw new IllegalArgumentException("Activite must not be null");
        }
        Utilisateur responsable = activite.getResponsable();
        if (responsable != null) {
            utilisateurRepository.save(responsable);
            responsable.addActivite(activite);
        }
        return activiteRepository.save(activite);
    }

    public Activite findOneActivite(Long id) {
        return this.activiteRepository.findOne(id);
    }

    public long countActivite() {
        return this.activiteRepository.count();
    }

    public ActiviteRepository getActiviteRepository() {
        return activiteRepository;
    }

    public ArrayList<Activite> findAllActivites() {
        Iterable<Activite> activites = activiteRepository.findAll(new Sort(new Sort.Order(Sort.Direction.ASC,"titre")));
        ArrayList<Activite> activitesList = new ArrayList<>();
        activites.forEach(activitesList::add);
        return activitesList;
    }
}
