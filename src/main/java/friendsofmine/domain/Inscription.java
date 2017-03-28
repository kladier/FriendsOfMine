package friendsofmine.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by what on 28/03/17.
 */
@Entity
public class Inscription {
    public Utilisateur getParticipant() {
        return participant;
    }

    public void setParticipant(Utilisateur user) {
        this.participant = user;
    }

    public Activite getActivite() {
        return activite;
    }

    public void setActivite(Activite activity) {
        this.activite = activity;
    }

    public Date getDateInscription() {
        return date;
    }

    public void setDateInscription(Date date) {
        this.date = date;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    public void setId ( Long id ) {
        this.id = id ;
    }

    @NotNull
    @ManyToOne
    private Utilisateur participant;

    @NotNull
    @ManyToOne
    private Activite activite;
    private Date date;

    public Inscription(Utilisateur util, Activite act, Date date) {
        this.activite = act;
        this.participant = util;
        this.date = date;
        if (date==null) {
            this.date = new Date();
        }
    }

    public Inscription() {}

    public Long getId() {
        return id;
    }
}
