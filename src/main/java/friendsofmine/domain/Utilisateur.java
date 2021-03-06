package friendsofmine.domain;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.Collection;
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
    public void setId ( Long id ) {
        this.id = id ;
    }

    @Email
    @NotNull
    private String email;

    @OneToMany(mappedBy = "responsable")
    private Collection<Activite> activites;

    public Collection<Activite> getActivites() {
        return this.activites;
    }

    public String getEmail() {
        return email;
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

    public Date getDateNaissance() {
        return dateNaissance;
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
    private Date dateNaissance;

    public Utilisateur() {

    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActivites(Collection<Activite> activites) {
        this.activites = activites;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public Utilisateur(String nom, String prenom, String email, String sexe, Date date) {
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.dateNaissance = date;
        this.activites = new ArrayList<Activite>();
    }

    public Utilisateur(String nom, String prenom, String email, String sexe) {
        this(nom, prenom, email, sexe, new Date());
    }

    public void addActivite(Activite activite) {
        if (!activites.contains(activite))
            activites.add(activite);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilisateur that = (Utilisateur) o;

        if (nom != null ? !nom.equals(that.nom) : that.nom != null) return false;
        if (prenom != null ? !prenom.equals(that.prenom) : that.prenom != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (dateNaissance != null ? !dateNaissance.equals(that.dateNaissance) : that.dateNaissance != null)
            return false;
        return sexe != null ? sexe.equals(that.sexe) : that.sexe == null;

    }

    @Override
    public int hashCode() {
        int result = nom != null ? nom.hashCode() : 0;
        result = 31 * result + (prenom != null ? prenom.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (dateNaissance != null ? dateNaissance.hashCode() : 0);
        result = 31 * result + (sexe != null ? sexe.hashCode() : 0);
        return result;
    }
}