/*
 * Copyright (c) 2015 DV Bern AG, Switzerland
 *
 * Das vorliegende Dokument, einschliesslich aller seiner Teile, ist urheberrechtlich
 * geschuetzt. Jede Verwertung ist ohne Zustimmung der DV Bern AG unzulaessig. Dies gilt
 * insbesondere fuer Vervielfaeltigungen, die Einspeicherung und Verarbeitung in
 * elektronischer Form. Wird das Dokument einem Kunden im Rahmen der Projektarbeit zur
 * Ansicht uebergeben ist jede weitere Verteilung durch den Kunden an Dritte untersagt.
 */
package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.Person;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.service.PersonDataService;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPersonDataView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;
import com.vaadin.navigator.ViewChangeListener;

import java.util.List;

public class PersonDataPresenter extends BasePresenter<PersonDataView, PersonDataModel> implements IPersonDataView, IPersonDataView.IPersonDataListener {


	private PersonDataService personDataService;

	public PersonDataPresenter(PersonDataView view, PersonDataModel model) {
		super(view, model);
		personDataService = new PersonDataService();
	}

	@Override
	public void onSaveButtonClicked() {
		Person person = model.getActivePerson();
		personDataService.savePerson(person);

	}

	@Override
	public void onDeleteButtonClicked() {
		Person person = model.getActivePerson();
		personDataService.deletePerson(person);

	}

	@Override
	public void onEditButtonClicked() {
		view.setToViewMode(model.getActivePerson());
	}

	@Override
	public void setToEditMode(Person person) {
		//noop
	}

	@Override
	public void setToViewMode(Person person) {
		//noop
	}

	@Override
	public void setMessage(String message) {
		//noop
	}

	@Override
	public void addListener(IPersonDataListener listener) {
		//noop
	}

	@Override
	public void enter(ViewChangeListener.ViewChangeEvent event) {
		List<Person> personen = personDataService.getPersonList();
		model.setPersonList(personen);
		model.setActivePerson(personen.get(0));
		view.fillAccordion(model.getPersonList());
		view.setToViewMode(model.getActivePerson());
	}
}
