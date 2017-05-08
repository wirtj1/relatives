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

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel;
import ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView;

public class PersonDataPresenter implements PersonDataView.PersonDataViewListener {

	private PersonDataModel model;
	private PersonDataView view;

	public PersonDataPresenter(PersonDataModel model, PersonDataView view) {
		this.model = model;
		this.view = view;
		view.setPersonen(model.getAllPersons("user"));
		view.addListener(this);
	}

	@Override
	public void listen() {

	}

}
