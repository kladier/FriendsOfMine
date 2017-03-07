package friendsofmine;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.ActiviteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiviteServiceTest {

    @Autowired
    private ActiviteService activiteService;

    private Activite act, act1;

    @Before
    public void setup() {
        act = new Activite("titre", "descriptif");
        act1 = new Activite("titre1", "descriptif1");
        activiteService.saveActivite(act1);
    }

    @Test
    public void testSaveActiviteHasId(){
        assertNull(act.getId());
        activiteService.saveActivite(act);
        assertNotNull(act.getId());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSaveActiviteNull(){
        activiteService.saveActivite(null);
    }

    @Test
    public void testActiviteRecupereeNotNull() {
        Activite fetched = activiteService.findOneActivite(act1.getId());
        assertNotNull(fetched);
    }

    @Test
    public void testActiviteRecupereeInchangee() {
        Activite fetched = activiteService.findOneActivite(act1.getId());
        assertEquals(fetched.getId(), act1.getId());
        assertEquals(fetched.getDescriptif(), act1.getDescriptif());
    }

    @Test
    @Transactional
    public void testActiviteMiseAJour() {
        Activite fetched = activiteService.findOneActivite(act1.getId());
        fetched.setDescriptif("Nouvelle description");
        activiteService.saveActivite(fetched);
        Activite fetchedUpdated = activiteService.findOneActivite(fetched.getId());
        assertEquals(fetched.getDescriptif(), fetchedUpdated.getDescriptif());
    }

    @Test
    @Transactional
    public void testNombreDActivitePersisteeApresMiseAJour() {
        long count = activiteService.countActivite();
        Activite fetched = activiteService.findOneActivite(act1.getId());
        fetched.setDescriptif("Nouvelle description");
        activiteService.saveActivite(fetched);
        assertEquals(count, activiteService.countActivite());
    }

    @Test
    public void testTypeRepository() {
        assertThat(activiteService.getActiviteRepository(), instanceOf(PagingAndSortingRepository.class));
    }
}
