package friendsofmine.domain;

//import org.springframework.data.annotation.Id;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by what on 27/02/17.
 */
@Entity
public class Activite {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    public Long getId () {
        return id ;
    }
    private void setId ( Long id ) {
        this.id = id ;
    }

    public Activite() {

    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @NotNull
    @Size(min=1)
    private String titre;

    public String getTitre() {
        return titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    private String descriptif;

    public Activite(String titre, String descriptif) {
        this.titre = titre;
        this.descriptif = descriptif;
    }

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
}
