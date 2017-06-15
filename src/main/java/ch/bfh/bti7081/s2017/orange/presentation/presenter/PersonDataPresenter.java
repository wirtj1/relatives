package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.service.PersonDataService;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Professional;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.states.PersonDataViewState;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.PersonGrid;
import com.vaadin.server.VaadinSession;

import java.util.ArrayList;
import java.util.Collection;
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
		Session session = getView().getUI().getCurrentSession();
		Person person = session.getAccount().getPerson();
		List<Person> personen = new ArrayList<>();
		if(person instanceof Professional){
			personen.addAll(getPersonsForProfessional((Professional) person));
		}else if(person instanceof Relative){
			personen.addAll(getPersonsForRelative((Relative) person));
		}
		model.setPersonList(personen);
		view.fillAccordion(model.getPersonList());
		model.setActivePersonGrid(view.getActivePersonGrid());
		getState().setMode();
	}

	private Collection<? extends Person> getPersonsForRelative(Relative relative) {
		return personDataService.getPersonsForRelative(relative);
	}

	private Collection<? extends Person> getPersonsForProfessional(Professional professional) {
		return personDataService.getPersonList();
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
