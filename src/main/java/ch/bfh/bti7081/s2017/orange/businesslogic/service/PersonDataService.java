
package ch.bfh.bti7081.s2017.orange.businesslogic.service;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.Person;

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
