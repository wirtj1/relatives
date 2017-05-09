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

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class PersonDataView extends BaseView implements IPersonDataView, IPersonDataView.IPersonDataListener {

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
	public void updatePerson(String person) {

	}

	@Override
	public void setToEditMode(Person person) {

	}

	@Override
	public void setToViewMode(Person person) {

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
		//wird aufgerufen, wenn auf diese View gewechselt wird
		String parameters = viewChangeEvent.getParameters();
		ParameterSet decodeParameterSet = ParameterSet.decode(parameters);
		messageLabel.setValue("Message was: " + decodeParameterSet.getParameter("message"));

	}

	@Override
	public String getViewName() {
		return "PersonDataView";
	}

	@Override
	public String getCaption() {
		return "Stammdaten Person";
	}

	@Override
	public void onSaveButtonClicked() {
		//noop
	}

	@Override
	public void onDeleteButtonClicked() {
		//noop
	}

	@Override
	public void onEditButtonClicked() {
		//noop
	}

	public void fillAccordion(List<Person> personList) {

	}
}
