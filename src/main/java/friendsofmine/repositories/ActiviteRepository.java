package friendsofmine.repositories;

import friendsofmine.domain.Activite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by what on 07/03/17.
 */
public interface ActiviteRepository extends CrudRepository<Activite,Long>, PagingAndSortingRepository<Activite, Long> {
}
