package ch.bfh.bti7081.s2017.orange.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yvesbeutler
 * Representation of a patient with his prescribed {@link Medication}.
 */
@Entity
public class Patient extends Person {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String oasi;
    @ManyToMany
    private List<Professional> professionals;
    @ManyToMany
    private List<Insurance> insurances;
    @OneToMany
    private List<Medication> medications;


    @ManyToMany
    private List<Relative> relatives = new ArrayList<>();
    private String goals;
    private String weekendInformation;
    private String yearPlanning;
    @OneToOne
    private Movement movement;
    @OneToOne
    private PinBoard pinBoard;

    public Patient(String firstName, String lastName) {
        super(firstName, lastName);
    }

    protected Patient()
    {
        super("", "");
    }


    public void addRelative(Relative relative)
    {
        relatives.add(relative);
    }


    public List<Relative> getRelatives() {
        return Collections.unmodifiableList(relatives);
    }

    public String getOasi() {
        return oasi;
    }

    public List<Insurance> getInsurances() {
        return insurances;
    }

    public String getGoals() {
        return goals;
    }

    public String getWeekendInformation() {
        return weekendInformation;
    }

    public String getYearPlanning() {
        return yearPlanning;
    }

    public Movement getMovement() {
        return movement;
    }

    public List<Medication> getMedications() {
        return medications;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public void setOasi(String oasi) {
        this.oasi = oasi;
    }

    public void setProfessionals(List<Professional> professionals) {
        this.professionals = professionals;
    }

    public void setInsurances(List<Insurance> insurances) {
        this.insurances = insurances;
    }

    public void setMedications(List<Medication> medications) {
        this.medications = medications;
    }

    public void setRelatives(List<Relative> relatives) {
        this.relatives = relatives;
    }

    public void setWeekendInformation(String weekendInformation) {
        this.weekendInformation = weekendInformation;
    }

    public void setYearPlanning(String yearPlanning) {
        this.yearPlanning = yearPlanning;
    }

    public void setMovement(Movement movement) {
        this.movement = movement;
    }

    public void setPinboard(PinBoard pinBoard) {
        this.pinBoard = pinBoard;
    }

    public List<Professional> getProfessionals() {
        return professionals;
    }

    public PinBoard getPinboard() {
        return pinBoard;
    }
}
