
package ch.bfh.bti7081.s2017.orange.businesslogic.service;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;

import java.util.ArrayList;
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
		//TODO call Repo and getAll Persons
		Relative r1 = new Relative();
		Relative r2 = new Relative();
		Relative r3 = new Relative();
//		r1.setFirstName("Leandro");
//		r1.setLastName("Lerena");
//		r1.setSocialAssuranceNumber("731.099.344.1");
//		r2.setFirstName("Jasmin");
//		r2.setLastName("Thevathas");
//		r2.setSocialAssuranceNumber("731.566.122.3");
//		r3.setFirstName("Sascha");
//		r3.setLastName("Wittwer");
//		r3.setSocialAssuranceNumber("732.433.322.8");
		ArrayList<Person> personList = new ArrayList<Person>();
		personList.add(r1);
		personList.add(r2);
		personList.add(r3);
		return personList;
	}
}
