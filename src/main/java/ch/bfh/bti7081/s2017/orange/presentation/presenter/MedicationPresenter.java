package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Account;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Medication;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PersonRepository;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.IMedicationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MedicationView;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationPresenter extends BasePresenter<MedicationView, MedicationModel> implements IMedicationView.IMedicationViewListener {

    public MedicationPresenter(MedicationView view, MedicationModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void onViewEnter(ParameterSet parameter) {
        Session session = view.getUI().getSession().getAttribute(Session.class);
        Account account = session.getAccount();
        Relative relative = (Relative) account.getPerson();
        PersonRepository repo = new PersonRepository();

        view.clearMedications();
        for (Medication med : repo.getPatientsByRelative(relative).get(0).getMedications()){
            MedicationModel model = new MedicationModel();

            model.setDose(med.getDose());
            model.setDescription(med.getNotes());
            model.setInterval(String.valueOf(med.getInterval()));
            model.setMedicine(med.getMedicine().getProductName());

            view.addMedication(model);
        }
    }
}
