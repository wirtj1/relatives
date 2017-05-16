package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.BaseModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import ch.bfh.bti7081.s2017.orange.presentation.views.IMedicationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MedicationView;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationPresenter extends BasePresenter<MedicationView, MedicationModel> implements IMedicationView.IMedicationViewListener {

    public MedicationPresenter(MedicationView view, MedicationModel model) {
        super(view, model);
    }

    @Override
    public void onViewEnter(ParameterSet parameter) {

    }

    @Override
    public void onMedicineClick() {

    }
}
