package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 30/05/2017.
 */
public class MedicationListModel {
    private List<MedicationModel> medications;

    public MedicationListModel()
    {
        medications = new ArrayList<>();
    }

    public void addMedication(MedicationModel model){
        medications.add(model);
    }

    public List<MedicationModel> getMedications()
    {
        return medications;
    }
}
