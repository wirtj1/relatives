package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.Person;
import com.vaadin.navigator.View;

/**
 * View interface for the {@link PersonDataView} that includes the listener interface used in the presenter {@link ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter}
 * @author Joy
 */
public interface IPersonDataView extends View {

	/**
	 * sets the view to the edit mode
	 * @param person
	 */
	void setToEditMode(Person person);

	/**
	 * sets the view to the view mode
	 * @param person
	 */
	void setToViewMode(Person person);

	/**
	 * sets a message to the view
	 * @param message
	 */
	void setMessage(String message);

	/**
	 * add a listener to the view
	 * @param listener
	 */
	void addListener(IPersonDataListener listener);

	/**
	 * this interface defines the methods for the presenter
	 */
	interface IPersonDataListener {
		/**
		 * called when the save button is clicked
		 */
		void onSaveButtonClicked();

		/**
		 * called when the delete button is clicked
		 */
		void onDeleteButtonClicked();

		/**
		 * called when the edit button is clicked
		 */
		void onEditButtonClicked();

		/**
		 * called when the view is entered
		 */
		void onViewEnter();
	}

}
