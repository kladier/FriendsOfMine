package friendsofmine;

import friendsofmine.controllers.ActiviteController;
import friendsofmine.services.InitialisationService;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(ActiviteController.class)
@RunWith(SpringRunner.class)
public class ActiviteControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ActiviteController activiteController;

    @Test
    public void testActivite() throws Exception{
        given(this.activiteController.getInitialisationService())
                .willReturn(new InitialisationService());
        mockMvc.perform(get("/activites"))
                .andExpect(content().contentType("text/html;charset=UTF-8"))
                .andExpect(status().is((200)))
                .andExpect(view().name("activites"))
                .andDo(print());
        //given(this.activiteController.list(new Model())).willReturn("activites");
        //String reverse = reverser.reverseSomeCall();
        //assertThat(reverse).isEqualTo("kcom");
    }
}