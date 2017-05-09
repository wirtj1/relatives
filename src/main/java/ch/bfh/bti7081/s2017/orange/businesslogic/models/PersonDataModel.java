/*
 * Copyright (c) 2015 DV Bern AG, Switzerland
 *
 * Das vorliegende Dokument, einschliesslich aller seiner Teile, ist urheberrechtlich
 * geschuetzt. Jede Verwertung ist ohne Zustimmung der DV Bern AG unzulaessig. Dies gilt
 * insbesondere fuer Vervielfaeltigungen, die Einspeicherung und Verarbeitung in
 * elektronischer Form. Wird das Dokument einem Kunden im Rahmen der Projektarbeit zur
 * Ansicht uebergeben ist jede weitere Verteilung durch den Kunden an Dritte untersagt.
 */
package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import java.util.List;

public class PersonDataModel extends BaseModel {

	private Person activePerson;
	private List<Person> personList;


	public void setPersonList(List<Person> personen) {
		this.personList = personen;

	}

	public void setActivePerson(Person person) {
		this.activePerson = person;

	}

	public List<Person> getPersonList() {
		return personList;
	}

	public Person getActivePerson() {
		return activePerson;
	}
}
