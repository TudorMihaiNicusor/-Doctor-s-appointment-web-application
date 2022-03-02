package raluandnic.client.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "consultatie")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id", scope = Consultatie.class)
public class Consultatie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "pacient_id", nullable = false)
    @ToString.Exclude
    private Pacient pacient;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    @ToString.Exclude
    private Doctor doctor;

    private Float temperatura;
    private String tensiunea;
    private String simptome;
    private String antecedente;
    private String heredocolaterale;
    private String reteta;
    private String diagnostic;
    private String data;

    public Consultatie(){
        this.id = 0;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Float temperatura) {
        this.temperatura = temperatura;
    }

    public String getTensiunea() {
        return tensiunea;
    }

    public void setTensiunea(String tensiunea) {
        this.tensiunea = tensiunea;
    }

    public String getSimptome() {
        return simptome;
    }

    public void setSimptome(String simptome) {
        this.simptome = simptome;
    }

    public String getAntecedente() {
        return antecedente;
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

    public String getReteta() {
        return reteta;
    }

    public void setReteta(String reteta) {
        this.reteta = reteta;
    }

    public String getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(String diagnostic) {
        this.diagnostic = diagnostic;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
