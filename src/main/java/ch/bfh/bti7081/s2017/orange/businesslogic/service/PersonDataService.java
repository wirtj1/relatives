
package ch.bfh.bti7081.s2017.orange.businesslogic.service;

import ch.bfh.bti7081.s2017.orange.persistence.entity.*;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PersonRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This service provides all the data used for the PersonData from the database
 * for model {@link ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView} view {@link ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView} and Presenter{@link ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter}
 * @author Joy
 */
public class PersonDataService {
	/**
	 * saves person
	 * @param person
	 */
	public void savePerson(Person person) {
		//TODO call Repo and Save Person
	}

	/**
	 * deletes a person
	 * @param person
	 */
	public void deletePerson(Person person) {
		//TODO call Repo and delete Person
	}

	/**
	 * returns the person
	 * @return
	 */
	public List<Person> getPersonList() {

		//TODO sobald das holen von der DB keine Null-Were mehr liefert
		// und die Daten Sinn machen, kann dies entfernt werden
		Patient p = new Patient("John", "Doe");
		p.setBirthdate(new Date());
		p.setPhone("079 456 45 45");
		p.setSalutation(Salutation.HERR);
		p.setTitle(Title.PROF);
		Address address = new Address();
		address.setStreetName("somestrasse");
		address.setCompany("Firma");
		address.setCity("Bern");
		address.setPostBox("");
		address.setCountry("CH");
		address.setPostalCode("3023");
		address.setStreetNumber("12");
		p.setAddress(address);
		p.setWeekendInformation("some info for the weekend");
		p.setYearPlanning("this is the plan for the year");
		p.setOasi("751.654.980.2");
		p.setGoals("goal one: be polite, goal two: be super polite");
		p.setInsurances(new ArrayList<Insurance>());
		p.setMedications(new ArrayList<Medication>());
		p.setMovement(new Movement());
		p.setPinboard(new PinBoard());
		p.setRelatives(new ArrayList<Relative>());
		p.setProfessionals(new ArrayList<Professional>());

		Relative r = new Relative();
		r.setFirstName("Maria");
		r.setLastName("Doe");
		r.setAddress(address);
		r.setBirthdate(new Date());
		r.setPhone("031 232 99 23");
		r.setSalutation(Salutation.FRAU);
		r.setTitle(Title.DR);

		List<Person> all = new ArrayList<>();
		all.add(p);
		all.add(r);
		return all;
	}
}
