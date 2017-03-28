package friendsofmine.repositories;

import friendsofmine.domain.Inscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by what on 28/03/17.
 */
public interface InscriptionRepository extends PagingAndSortingRepository<Inscription, Long> {

    Page<Inscription> findByParticipantNomOrActiviteTitreAllIgnoreCase(String nom, String titre, Pageable pageable);
}
