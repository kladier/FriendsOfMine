package friendsofmine.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by what on 27/02/17.
 */
public class Activite {
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
}
