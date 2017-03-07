package friendsofmine;

import friendsofmine.controllers.IndexController;
import friendsofmine.controllers.UtilisateurController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class UtilisateurControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUtilisateur() throws Exception{
        this.mockMvc.perform(get("/utilisateurs"))
                .andExpect(status().isOk())
                .andExpect(view().name("utilisateurs"))
                .andDo(print());
    }
}