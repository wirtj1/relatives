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

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import com.vaadin.ui.Accordion;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

public class PersonDataView extends CustomComponent {

	private List<PersonDataModel.Person> personList = new ArrayList<>();
	private VerticalLayout layout;


	public PersonDataView() {
		layout = new VerticalLayout();
		setCompositionRoot(layout);
	}

	public void setPersonen(List<PersonDataModel.Person> personen) {
		personList = personen;
		Accordion accordion = new Accordion();
		for (PersonDataModel.Person person : personList) {
			VerticalLayout personTab = new VerticalLayout();
			personTab.addComponent(new Label("Vorname: " + person.getVorname()));
			personTab.addComponent(new Label("Nachname: " + person.getNachname()));
			personTab.addComponent(new Label("Email Adresse: " + person.getEmailadresse()));
			personTab.addComponent(new Label("Telefonnummer: " + person.getTelefonnummer()));
			personTab.addComponent(new Label("Krankenkasse: " + person.getKrankenkasse()));
			accordion.addTab(personTab, person.getVorname() + " " + person.getNachname());
			layout.addComponent(accordion);
		}
	}

	public interface PersonDataViewListener {
		void listen();
	}

	private List<PersonDataViewListener> listeners = new ArrayList<>();

	public void addListener(PersonDataViewListener listener) {
		listeners.add(listener);
	}


}
