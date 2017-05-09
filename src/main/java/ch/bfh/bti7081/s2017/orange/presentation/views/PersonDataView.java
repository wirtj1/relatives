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
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class PersonDataView extends BaseView implements IPersonDataView{

	private List<IPersonDataListener> listeners;

	private List<String> personList;

	//TODO wijo define used view components here
	private VerticalLayout layout;
	private Label messageLabel;
	private Accordion personAccordion;
	private Button saveButton;
	private Button deleteButton;
	private Button editButton;

	public PersonDataView() {
		listeners = new ArrayList<>();
		//TODO initialize defined view components here
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
		//TODO wijo enable disable buttons usw, set open Person
	}

	@Override
	public void setToViewMode(Person person) {
		//TODO enable disable buttons usw, set open Person

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
			personTab.addComponent(new Label("Vorname"));
			personTab.addComponent(new Label("Nachname"));
			personTab.addComponent(new Label("AHV Nummer"));
			personAccordion.addTab(personTab, "Vorname Nachname");
		}
		layout.addComponent(personAccordion);

	}
}
