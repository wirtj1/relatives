package ch.bfh.bti7081.s2017.orange.presentation.presenter.states;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.PersonGrid;

/**
 * @author Leandro on 20/5/2017.
 * Represents the state of the person data view in edit mode.
 */
public class PersonDataEditState extends BasePresenterState<PersonDataPresenter> implements IPersonDataView.IPersonDataListener {

    public PersonDataEditState(PersonDataPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onSaveButtonClicked(PersonGrid personGrid) {
        PersonDataPresenter presenter = getPresenter();
        boolean isValid = personGrid.getBinder().writeBeanIfValid(personGrid.getPerson());
        if(isValid) {
            Person person = presenter.savePerson(personGrid.getPerson());
            personGrid.setPerson(person);
            changeToViewState(personGrid);
        }else{
            getPresenter().getModel().setActivePersonGrid(personGrid);
        }
    }

    @Override
    public void onDeleteButtonClicked(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);

    }

    @Override
    public void onEditButtonClicked(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);
        //noop
    }

    @Override
    public void onCancelButtonClicked(PersonGrid personGrid) {
        changeToViewState(personGrid);
    }

    private void changeToViewState(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);
        PersonDataPresenter presenter = getPresenter();
        PersonDataView view = presenter.getView();
        presenter.setState(new PersonDataViewState(presenter));
        view.addListener(presenter.getState());
        presenter.getState().setMode();
        view.removeListener(this);
    }

    @Override
    public void onViewEnter() {

    }

    @Override
    public void setMode() {
        PersonDataPresenter presenter = getPresenter();
        presenter.getView().setToEditMode(presenter.getModel().getActivePersonGrid());
    }
}
