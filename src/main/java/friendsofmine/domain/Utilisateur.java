package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;

import javax.rmi.CORBA.Util;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by what on 27/02/17.
 */
public class Utilisateur {
    @Email
    @NotNull
    private String mail;
    @NotNull
    @Size(min=1)
    private String nom;
    @NotNull
    @Size(min=1)
    private String prenom;
    @NotNull
    @Pattern(regexp="[MF]")
    private String sexe;
    private Date date;

    public Utilisateur(String nom, String prenom, String mail, String sexe, Date date) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.date = date;
    }

    public Utilisateur(String nom, String prenom, String mail, String sexe) {
        this(nom, prenom, mail, sexe, new Date());
    }
}