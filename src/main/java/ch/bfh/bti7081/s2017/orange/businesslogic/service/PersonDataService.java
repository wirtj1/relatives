/*
 * Copyright (c) 2015 DV Bern AG, Switzerland
 *
 * Das vorliegende Dokument, einschliesslich aller seiner Teile, ist urheberrechtlich
 * geschuetzt. Jede Verwertung ist ohne Zustimmung der DV Bern AG unzulaessig. Dies gilt
 * insbesondere fuer Vervielfaeltigungen, die Einspeicherung und Verarbeitung in
 * elektronischer Form. Wird das Dokument einem Kunden im Rahmen der Projektarbeit zur
 * Ansicht uebergeben ist jede weitere Verteilung durch den Kunden an Dritte untersagt.
 */
package ch.bfh.bti7081.s2017.orange.businesslogic.service;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.Person;

import java.util.ArrayList;
import java.util.List;

public class PersonDataService {
	public void savePerson(Person person) {
		//TODO call Repo and Save Person
	}

	public void deletePerson(Person person) {
		//TODO call Repo and delete Person
	}

	public List<Person> getPersonList() {
		//TODO call Repo and getAll Persons

		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		p1.setFirstName("Leandro");
		p1.setLastName("Lerena");
		p1.setSocialAssuranceNumber("731.099.344.1");
		p2.setFirstName("Jasmin");
		p2.setLastName("Thevathas");
		p2.setSocialAssuranceNumber("731.566.122.3");
		p3.setFirstName("Sascha");
		p3.setLastName("Wittwer");
		p3.setSocialAssuranceNumber("732.433.322.8");
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		return personList;

	}
}
