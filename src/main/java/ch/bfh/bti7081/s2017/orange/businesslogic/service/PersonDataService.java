
package ch.bfh.bti7081.s2017.orange.businesslogic.service;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PersonRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * This service provides all the data used for the PersonData from the database
 * for model {@link ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView} view {@link ch.bfh.bti7081.s2017.orange.presentation.views.PersonDataView} and Presenter{@link ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter}
 * @author Joy
 */
public class PersonDataService {
	PersonRepository personRepository = new PersonRepository();

	/**
	 * saves person
	 *
	 * @param person
	 */
	public Person savePerson(Person person) {
		return personRepository.savePerson(person);
	}

	/**
	 * deletes a person
	 *
	 * @param person
	 */
	public void deletePerson(Person person) {
		//no Deletion required
	}

	/**
	 * returns all persons in the database
	 *
	 * @return list of persons
	 */
	public List<Person> getPersonList() {
		List<Person> personList = personRepository.getAll();
		return personList;
	}

	/**
	 * returns all persons for the given relative
	 * @param relative
	 * @return list of persons
	 */
	public Collection<? extends Person> getPersonsForRelative(Relative relative) {
		List<Person> personList = new ArrayList<>();
		List<Patient> patientsByRelative = personRepository.getPatientsByRelative(relative);
		for (Patient patient : patientsByRelative) {
			personList.addAll(patient.getProfessionals());
			personList.addAll(patient.getRelatives());
			personList.add(patient);
		}
		return personList;
	}
}