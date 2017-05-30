package ch.bfh.bti7081.s2017.orange.businesslogic.models;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationModel extends BaseModel {
    private String medicine;
    private String dose;

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String interval;
    private String description;

    public MedicationModel(){
        interval = "";
        dose = "";
        medicine = "";
        description ="";
    }

    @Override
    public String toString()
    {
        return medicine;
    }
}
