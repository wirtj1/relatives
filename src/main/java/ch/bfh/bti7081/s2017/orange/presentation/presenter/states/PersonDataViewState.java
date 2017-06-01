package ch.bfh.bti7081.s2017.orange.presentation.presenter.states;

import ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.PersonGrid;

/**
 * @author Leandro on 20/5/2017.
 * Represents the state of the person data view in view mode.
 */
public class PersonDataViewState extends BasePresenterState<PersonDataPresenter> implements IPersonDataView.IPersonDataListener {

    public PersonDataViewState(PersonDataPresenter presenter) {
        super(presenter);
    }

    @Override
    public void onSaveButtonClicked(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);
        //not yet implemented
    }

    @Override
    public void onDeleteButtonClicked(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);
        //not yet implemented
    }

    @Override
    public void onEditButtonClicked(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);
        //change to Edit mode
        PersonDataPresenter presenter = getPresenter();
        PersonDataView view = presenter.getView();

        presenter.setState(new PersonDataEditState(presenter));
        view.addListener(presenter.getState());
        presenter.getState().setMode();
        view.removeListener(this);
    }

    @Override
    public void onCancelButtonClicked(PersonGrid personGrid) {
        getPresenter().getModel().setActivePersonGrid(personGrid);
        //noop

    }

    @Override
    public void onViewEnter() {

    }

    @Override
    public void setMode() {
        PersonDataPresenter presenter = getPresenter();
        presenter.getView().setToViewMode(presenter.getModel().getActivePersonGrid());
    }
}
