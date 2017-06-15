package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PersonRepository;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PinboardRepository;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinCreationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinboardView;

import java.util.List;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardPresenter extends BasePresenter<PinboardView, PinboardModel>
        implements IPinboardView.IPinboardViewListener
{

    private PinboardRepository pinboardRepo = new PinboardRepository(PinBoard.class);
    private PersonRepository personRepo = new PersonRepository();

    public PinboardPresenter(PinboardView view, PinboardModel model)
    {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void navigateToAddPinEntry()
    {
        view.getUI().getNavigator().navigateTo(PinCreationView.class);
    }

    @Override
    public void onViewEnter()
    {
        Person user = view.getUI().getSession().getAttribute(Session.class).getPerson();
        model.setPinboard(pinboardRepo.getPinboardByRelative((Relative) user));

        view.setPinboardModel(model);
        List<Patient> patients = personRepo.getPatientsByRelative((Relative) user);
        view.setPatient(patients.get(0));
    }

}
