package raluandnic.client.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pacient")
public class Pacient extends User{

    private String antecedente;
    private String heredocolaterale;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @ToString.Exclude
    private Doctor doctor;
    @OneToMany(mappedBy = "pacient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Consultatie> consultatii = new ArrayList<>();

    public Pacient() {
        this.antecedente = "";
        this.heredocolaterale = "";
    }

    public Pacient(User user){
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setFirstname(user.getFirstname());
        this.setLastname(user.getLastname());
        this.setType(user.getType());
    }

    public List<Consultatie> getConsultatii() {
        return consultatii;
    }

    public void setConsultatii(List<Consultatie> consultatii) {
        this.consultatii = consultatii;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getAntecedente() {
        return this.antecedente;
    }

    public void setAntecedente(String antecedente) {
        this.antecedente = antecedente;
    }

    public String getHeredocolaterale() {
        return heredocolaterale;
    }

    public void setHeredocolaterale(String heredocolaterale) {
        this.heredocolaterale = heredocolaterale;
    }

}

