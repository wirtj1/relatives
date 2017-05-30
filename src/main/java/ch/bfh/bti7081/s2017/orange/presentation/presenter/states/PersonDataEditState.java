package ch.bfh.bti7081.s2017.orange.presentation.presenter.states;

import ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;

/**
 * @author Leandro on 20/5/2017.
 * Represents the state of the person data view in edit mode.
 */
public class PersonDataEditState extends BasePresenterState<PersonDataPresenter>  implements IPersonDataView.IPersonDataListener {

    public PersonDataEditState(PersonDataPresenter presenter)
    {
        super(presenter);
    }

    @Override
    public void onSaveButtonClicked() {

    }

    @Override
    public void onDeleteButtonClicked() {

    }

    @Override
    public void onEditButtonClicked() {

    }

    @Override
    public void onViewEnter() {

    }
}
