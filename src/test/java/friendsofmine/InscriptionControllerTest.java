package friendsofmine;

import friendsofmine.domain.Activite;
import friendsofmine.domain.Inscription;
import friendsofmine.domain.Utilisateur;
import friendsofmine.service.InscriptionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InscriptionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private InscriptionService inscriptionService;

    @Autowired
    private Bootstrap bootstrap;

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    @Test
    public void testShowInscriptionExistante() throws Exception {

        Inscription maryOnTaekwondo = bootstrap.getInitialisationService().getMaryOnTaekwondo();

        mockMvc.perform(get("/api/inscription/" + maryOnTaekwondo.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(maryOnTaekwondo.getId().intValue())))
                .andExpect(jsonPath("$.participant.nom", is(maryOnTaekwondo.getParticipant().getNom())))
                .andExpect(jsonPath("$.activite.titre", is(maryOnTaekwondo.getActivite().getTitre())));
    }

    @Test
    public void testShowInscriptionInexistante() throws Exception {

        Long idInexistant = 12345L;

        // assert that idInexistant does not correspond to an existing Inscription
        assertNull(inscriptionService.findOneInscription(idInexistant));

        mockMvc.perform(get("/api/inscription/" + idInexistant))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAjoutInscription() throws Exception {

        Utilisateur mary = bootstrap.getInitialisationService().getMary();
        Activite rando = bootstrap.getInitialisationService().getRandonnee();

        mockMvc.perform(post("/api/inscription?utilisateur_id=" + mary.getId() + "&activite_id=" + rando.getId()))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.participant.nom", is(mary.getNom())))
                .andExpect(jsonPath("$.activite.titre", is(rando.getTitre())));
    }

    @Test
    public void testDelete() throws Exception {
        Inscription thomOnLindyhop = bootstrap.getInitialisationService().getThomOnLindyhop();
        Long count = inscriptionService.countInscription();

        mockMvc.perform(delete("/api/inscription/" + thomOnLindyhop.getId()))
                .andExpect(status().isOk());

        assertEquals(count - 1, inscriptionService.countInscription());
    }

    @Test
    public void testSearchVide() throws Exception {
        mockMvc.perform(get("/api/inscription/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(3)))
                .andDo(print());
    }

    @Test
    public void testSearchNomSimple() throws Exception {
        mockMvc.perform(get("/api/inscription/search?nom_utilisateur=" + bootstrap.getInitialisationService().getThom().getNom()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }

    @Test
    public void testSearchNomSimpleAvecCasse() throws Exception {
        mockMvc.perform(get("/api/inscription/search?nom_utilisateur=" + bootstrap.getInitialisationService().getThom().getNom().toUpperCase()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }

    @Test
    public void testSearchActiviteSimple() throws Exception {
        mockMvc.perform(get("/api/inscription/search?titre_activite=" + bootstrap.getInitialisationService().getLindyhop().getTitre()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(1)))
                .andDo(print());
    }

    @Test
    public void testSearchNomEtActivite() throws Exception {
        mockMvc.perform(get("/api/inscription/search?nom_utilisateur=" + bootstrap.getInitialisationService().getThom().getNom()
                + "&titre_activite=" + bootstrap.getInitialisationService().getLindyhop().getTitre()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$", hasSize(2)))
                .andDo(print());
    }

}
