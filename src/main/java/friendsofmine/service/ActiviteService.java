package friendsofmine.service;

import friendsofmine.domain.Activite;
import friendsofmine.repositories.ActiviteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * Created by what on 07/03/17.
 */
@Service
public class ActiviteService {
    @Autowired
    private ActiviteRepository activiteRepository;

    public void saveActivite(Activite act) {
        if (act == null) {
            throw new IllegalArgumentException();
        }
        this.activiteRepository.save(act);
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
}
