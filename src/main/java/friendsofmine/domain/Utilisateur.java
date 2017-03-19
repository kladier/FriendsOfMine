package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;
import javax.persistence.Id;

import org.springframework.data.annotation.Persistent;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.rmi.CORBA.Util;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by what on 27/02/17.
 */
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    public Long getId () {
        return id ;
    }
    private void setId ( Long id ) {
        this.id = id ;
    }

    @Email
    @NotNull
    private String mail;

    private ArrayList<Activite> activites;

    public ArrayList<Activite> getActivites() {
        return this.activites;
    }

    public String getEmail() {
        return mail;
    }

    public void setEmail(String email) {
        this.mail = email;
    }
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public Date getDate() {
        return date;
    }

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

    public Utilisateur() {

    }

    public Utilisateur(String nom, String prenom, String mail, String sexe, Date date) {
        this.mail = mail;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.date = date;
        this.activites = new ArrayList<Activite>();
    }

    public Utilisateur(String nom, String prenom, String mail, String sexe) {
        this(nom, prenom, mail, sexe, new Date());
    }
}