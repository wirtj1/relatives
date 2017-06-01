package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.views.components.PersonGrid;

/**
 * View interface for the {@link PersonDataView} that includes the listener interface used in the presenter {@link ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter}
 *
 * @author Joy
 */
public interface IPersonDataView extends IBaseView {

    /**
     * sets the view to the edit mode
     *
     * @param personGrid
     */
    void setToEditMode(PersonGrid personGrid);

    /**
     * sets the view to the view mode
     *
     * @param personGrid
     */
    void setToViewMode(PersonGrid personGrid);

    /**
     * sets a message to the view
     *
     * @param message
     */
    void setMessage(String message);

    /**
     * add a listener to the view
     *
     * @param listener
     */
    void addListener(IPersonDataListener listener);


    /**
     * aremove a listener from  the view
     *
     * @param listener
     */
    void removeListener(IPersonDataListener listener);

    /**
     * this interface defines the methods for the presenter
     */
    interface IPersonDataListener extends IBaseViewListener {
        /**
         * called when the save button is clicked
         */
        void onSaveButtonClicked(PersonGrid personGrid);

        /**
         * called when the delete button is clicked
         */
        void onDeleteButtonClicked(PersonGrid personGrid);

        /**
         * called when the edit button is clicked
         */
        void onEditButtonClicked(PersonGrid personGrid);

        /**
         * called when the cacnel button is clicked
         */
        void onCancelButtonClicked(PersonGrid personGrid);

        /**
         * called when the view is entered
         */
        void onViewEnter();

        /**
         * set Mode on View
         */
        void setMode();

    }

}
