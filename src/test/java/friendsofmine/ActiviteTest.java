package friendsofmine;

import friendsofmine.domain.Activite;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

public class ActiviteTest {

    private static Validator validator;

    @BeforeClass
    public static void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testTitreNonVideEtDescrptif() {
        Activite act = new Activite("unTitre", "unDescriptif");
        assertTrue(validator.validate(act).size() == 0);
    }

    @Test
    public void testTitreNonVideEtDescriptifVide() {
        Activite act = new Activite("unTitre", "");
        assertTrue(validator.validate(act).size() == 0);
    }

    @Test
    public void testTitreNonVideEtDescriptifNull() {
        Activite act = new Activite("unTitre", null);
        assertTrue(validator.validate(act).size() == 0);
    }

    @Test
    public void testTitreVide() {
        Activite act = new Activite("", "unDescriptif");
        assertTrue(validator.validate(act).size() != 0);
    }

    @Test
    public void testTitreNull() {
        Activite act = new Activite(null, "unDescriptif");
        assertTrue(validator.validate(act).size() != 0);
    }
}