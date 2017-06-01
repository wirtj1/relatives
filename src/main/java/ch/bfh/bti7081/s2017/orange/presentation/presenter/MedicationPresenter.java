package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.BaseModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationListModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Medication;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.MedicationRepository;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import ch.bfh.bti7081.s2017.orange.presentation.views.IMedicationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MedicationView;

import java.util.Optional;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationPresenter extends BasePresenter<MedicationView, MedicationModel> implements IMedicationView.IMedicationViewListener {

    private MedicationRepository repo = new MedicationRepository(Medication.class);

    public MedicationPresenter(MedicationView view, MedicationModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void onViewEnter(ParameterSet parameter) {

        MedicationListModel medicationListModel = new MedicationListModel();
        for (Medication med : repo.getAll()){
            MedicationModel model = new MedicationModel();

            model.setDose(med.getDose());
            model.setDescription(med.getNotes());
            model.setInterval(String.valueOf(med.getInterval()));
            model.setMedicine(med.getMedicine().getProductName());

            medicationListModel.addMedication(model);
        }

        view.setMedications(medicationListModel);
    }

    @Override
    public void onMedicineClick(MedicationModel model) {
        view.setCurrentMedication(model);
    }
}
