package ch.bfh.bti7081.s2017.orange.businesslogic.models;

import java.util.List;

/**
 * Model of the View {@link PersonDataModel} and the Presenter {@link ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter}
 * @author Joy
 **/
public class PersonDataModel extends BaseModel {

	private Person activePerson;
	private List<Person> personList;

	/**
	 * sets the personList to the model that will be used in the view
	 * @param personen
	 */
	public void setPersonList(List<Person> personen) {
		this.personList = personen;

	}

	/**
	 * sets the active person to the model that will be used in the view
	 * @param person
	 */
	public void setActivePerson(Person person) {
		this.activePerson = person;

	}

	/**
	 * returns the personList that is shown in the view
	 * @return personList
	 */
	public List<Person> getPersonList() {
		return personList;
	}

	/**
	 * returns the active person that is showed in the view
	 * @return activePerson
	 */
	public Person getActivePerson() {
		return activePerson;
	}
}
