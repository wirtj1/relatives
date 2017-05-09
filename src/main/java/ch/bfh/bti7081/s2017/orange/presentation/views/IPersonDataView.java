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
import com.vaadin.navigator.View;


public interface IPersonDataView extends View {


	//TODO wijo zu Personen aendern
	void setToEditMode(Person person);

	void setToViewMode(Person person);

	void setMessage(String message);

	interface IPersonDataListener {
		void onSaveButtonClicked();

		void onDeleteButtonClicked();

		void onEditButtonClicked();
	}

	void addListener(IPersonDataListener listener);
}
