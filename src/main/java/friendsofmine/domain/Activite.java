package friendsofmine.domain;

//import org.springframework.data.annotation.Id;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
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
        this("","", null);
    }

    public Activite(String titre, String descriptif) {
        this(titre, descriptif, null);
    }

    public Activite(String titre, String descriptif, Utilisateur responsable) {
        this.titre = titre;
        this.descriptif = descriptif;
        this.responsable = responsable;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @NotNull
    @Size(min=1)
    private String titre;

    @ManyToOne
    @NotNull
    @JsonIgnore
    private Utilisateur responsable;

    public Utilisateur getResponsable() {
        return this.responsable;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescriptif() {
        return descriptif;
    }

    private String descriptif;

    public void setDescriptif(String descriptif) {
        this.descriptif = descriptif;
    }
}
