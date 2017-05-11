/*
 * Copyright (c) 2015 DV Bern AG, Switzerland
 *
 * Das vorliegende Dokument, einschliesslich aller seiner Teile, ist urheberrechtlich
 * geschuetzt. Jede Verwertung ist ohne Zustimmung der DV Bern AG unzulaessig. Dies gilt
 * insbesondere fuer Vervielfaeltigungen, die Einspeicherung und Verarbeitung in
 * elektronischer Form. Wird das Dokument einem Kunden im Rahmen der Projektarbeit zur
 * Ansicht uebergeben ist jede weitere Verteilung durch den Kunden an Dritte untersagt.
 */
package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.Person;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

public class PersonDataView extends BaseView implements IPersonDataView {

	private List<IPersonDataListener> listeners;

	// define used view components here
	private VerticalLayout layout;
	private Label messageLabel;
	private Accordion personAccordion;
	private Button saveButton;
	private Button deleteButton;
	private Button editButton;

	public PersonDataView() {
		listeners = new ArrayList<>();
		messageLabel = new Label();

		saveButton = new Button();
		//saveButton.addClickListener();

		deleteButton = new Button();
		//deleteButton.addClickListener();

		editButton = new Button();
		//editButton.addClickListener();

		layout = new VerticalLayout();
		layout.addComponent(messageLabel);
		setCompositionRoot(layout);
	}


	@Override
	public void setToEditMode(Person person) {
		// enable disable buttons usw, set open Person
	}

	@Override
	public void setToViewMode(Person person) {
		//enable disable buttons usw, set open Person

	}

	@Override
	public void setMessage(String value) {
		messageLabel.setValue(value);
	}

	@Override
	public void addListener(IPersonDataListener listener) {
		listeners.add(listener);
	}


	@Override
	public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
		for (IPersonDataListener listener : listeners) {
			listener.onViewEnter();
		}
	}

	@Override
	public String getViewName() {
		return "PersonDataView";
	}

	@Override
	public String getCaption() {
		return "Stammdaten Person";
	}


	public void fillAccordion(List<Person> personList) {
		if (personAccordion == null) {
			personAccordion = new Accordion();
		} else {
			personAccordion.removeAllComponents();
		}

		for (Person person : personList) {
			VerticalLayout personTab = new VerticalLayout();
			GridLayout grid = new GridLayout(2,3);
			// Layout containing relatively sized components must have
			// a defined size, here is fixed size.
			grid.setWidth("400px");
			grid.setHeight("100px");
			grid.addComponent(new Label("Vorname"));
			grid.addComponent(new Label(person.getFirstName()));
			grid.addComponent(new Label("Nachname"));
			grid.addComponent(new Label(person.getLastName()));
			grid.addComponent(new Label("AHV Nummer"));
			grid.addComponent(new Label(person.getSocialAssuranceNumber()));
			personTab.addComponent(grid);
			personAccordion.addTab(personTab, (person.getFirstName() + " " + person.getLastName()));
		}

		layout.addComponent(personAccordion);

	}
}
