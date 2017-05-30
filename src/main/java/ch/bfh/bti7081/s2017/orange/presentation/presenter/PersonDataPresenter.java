package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.service.PersonDataService;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.states.PersonDataViewState;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;

import java.util.List;

/**
 * Presenter that connects the view {@link PersonDataView} and the model {@link PersonDataModel}
 *
 * @author Joy
 */
public class PersonDataPresenter extends BaseContextPresenter<PersonDataView, PersonDataModel, IPersonDataView.IPersonDataListener> implements IPersonDataView.IPersonDataListener
{

    private PersonDataService personDataService;


    public PersonDataPresenter(PersonDataView view, PersonDataModel model)
    {
        super(view, model);
        personDataService = new PersonDataService();
        view.addListener(this);

        //Todo: Use State with getState and delegate methods from IPersonDataView.IPersonDataListener
        setState(new PersonDataViewState(this));
    }

    @Override
    public void onSaveButtonClicked()
    {
        Person person = model.getActivePerson();
        personDataService.savePerson(person);

    }

    @Override
    public void onDeleteButtonClicked()
    {
        Person person = model.getActivePerson();
        personDataService.deletePerson(person);

    }

    @Override
    public void onEditButtonClicked()
    {
        view.setToViewMode(model.getActivePerson());
    }

    @Override
    public void onViewEnter()
    {
        List<Person> personen = personDataService.getPersonList();
        model.setPersonList(personen);
        model.setActivePerson(personen.get(0));
        view.fillAccordion(model.getPersonList());
        view.setToViewMode(model.getActivePerson());
    }

}
