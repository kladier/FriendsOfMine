package friendsofmine.repositories;

import friendsofmine.domain.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by what on 07/03/17.
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur,Long>, PagingAndSortingRepository<Utilisateur, Long> {
}
