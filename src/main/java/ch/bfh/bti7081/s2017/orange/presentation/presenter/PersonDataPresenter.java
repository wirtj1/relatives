package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.service.PersonDataService;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.states.PersonDataViewState;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.PersonGrid;

import java.util.List;

/**
 * Presenter that connects the view {@link PersonDataView} and the model {@link PersonDataModel}
 * @author Joy
 */
public class PersonDataPresenter extends BaseContextPresenter<PersonDataView, PersonDataModel, IPersonDataView.IPersonDataListener> implements IPersonDataView.IPersonDataListener {

	private PersonDataService personDataService;


	public PersonDataPresenter(PersonDataView view, PersonDataModel model) {
		super(view, model);
		personDataService = new PersonDataService();
		view.addListener(this);
		setState(new PersonDataViewState(this));
		view.addListener(getState());
	}

	@Override
	public void onSaveButtonClicked(PersonGrid personGrid) {
		//noop
	}


	@Override
	public void onDeleteButtonClicked(PersonGrid personGrid) {
		model.setActivePersonGrid(personGrid);
		personDataService.deletePerson(model.getActivePersonGrid().getPerson());
		model.setActivePersonGrid(null);

	}

	@Override
	public void onEditButtonClicked(PersonGrid personGrid) {
		//noop
	}

	@Override
	public void onCancelButtonClicked(PersonGrid personGrid) {
		//noop
	}

	@Override
	public void onViewEnter() {
		List<Person> personen = personDataService.getPersonList();
		model.setPersonList(personen);
		view.fillAccordion(model.getPersonList());
		model.setActivePersonGrid(view.getActivePersonGrid());
		getState().setMode();
	}

	@Override
	public void setMode() {
		//noop
	}

	/**
	 * call service and save person to database
	 * @param person
	 * @return updated person
	 */
	public Person savePerson(Person person) {
		return personDataService.savePerson(person);
	}
}
