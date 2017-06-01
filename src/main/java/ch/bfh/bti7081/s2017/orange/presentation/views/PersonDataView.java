package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Professional;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.PatientGrid;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.PersonGrid;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.ProfessionalGrid;
import ch.bfh.bti7081.s2017.orange.presentation.views.components.RelativeGrid;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Scrollable;
import com.vaadin.ui.*;
import org.hibernate.cfg.NotYetImplementedException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * This view shows the BasicData of the persons and is connected to the presenter {@link ch.bfh.bti7081.s2017.orange.presentation.presenter.PersonDataPresenter} and the model {@link ch.bfh.bti7081.s2017.orange.businesslogic.models.PersonDataModel}
 *
 * @author Joy
 */
public class PersonDataView extends BaseView implements IPersonDataView {

    private List<IPersonDataListener> listeners;

    // define used view components here
    private Scrollable scrollable;
    private VerticalLayout layout;
    private Label messageLabel;
    private Accordion personAccordion;

    public PersonDataView() {
        listeners = new ArrayList<>();
        messageLabel = new Label();

        layout = new VerticalLayout();
        layout.addComponent(messageLabel);
        setCompositionRoot(layout);
    }


    @Override
    public void setToEditMode(PersonGrid personGrid) {
        if(personGrid!=null) {
            personGrid.setToEditMode();
        }
    }

    @Override
    public void setToViewMode(PersonGrid personGrid) {
        Iterator<Component> iterator = personAccordion.iterator();
        while (iterator.hasNext()) {
            PersonGrid next = (PersonGrid) iterator.next();
            next.setToViewMode();
        }
    }

    @Override
    public void setMessage(String value) {
        messageLabel.setValue(value);
    }

    @Override
    public void addListener(IPersonDataListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(IPersonDataListener listener) {
        listeners.remove(listener);
    }


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        for (IPersonDataListener listener : listeners) {
            listener.onViewEnter();
        }
    }

    @Override
    public String getViewName() {
        return "PersonDataView";
    }

    @Override
    public String getCaption() {
        return "Stammdaten Person";
    }


    /**
     * fills the accordion with the persons provided from the model
     *
     * @param personList
     */
    public void fillAccordion(List<Person> personList) {
        if (personAccordion == null) {
            personAccordion = new Accordion();
        } else {
            personAccordion.removeAllComponents();
        }

        for (Person person : personList) {
            PersonGrid personGrid = getGrid(person);
            personGrid.getCancelButton().addClickListener(clickEvent -> onCancel(personGrid));
            personGrid.getDeleteButton().addClickListener(clickEvent -> onDelete(personGrid));
            personGrid.getSaveButton().addClickListener(clickEvent -> onSave(personGrid));
            personGrid.getEditButton().addClickListener(clickEvent -> onEdit(personGrid));
            personAccordion.addTab(personGrid, (person.getFirstName() + " " + person.getLastName()));
        }
        layout.addComponent(personAccordion);
    }

    private PersonGrid getGrid(Person person) {
        if(person instanceof Relative){
           return new RelativeGrid((Relative)person);
        }else if(person instanceof Patient){
            return new PatientGrid((Patient) person);
        }else if(person instanceof Professional){
            return new ProfessionalGrid((Professional) person);
        }else{
            throw new NotYetImplementedException("fuuu");
        }
    }

    public PersonGrid getActivePersonGrid(){
        return (PersonGrid) personAccordion.getSelectedTab();
    }

    private void onEdit(PersonGrid personGrid) {
        for (IPersonDataListener listener : listeners) {
            listener.onEditButtonClicked(personGrid);
        }
    }

    private void onCancel(PersonGrid personGrid) {
        for (IPersonDataListener listener : listeners) {
            listener.onCancelButtonClicked(personGrid);
        }
    }

    private void onSave(PersonGrid personGrid) {
        for (IPersonDataListener listener : listeners) {
            listener.onSaveButtonClicked(personGrid);
        }
    }

    private void onDelete(PersonGrid personGrid) {
        for (IPersonDataListener listener : listeners) {
            listener.onDeleteButtonClicked(personGrid);
        }
    }

}
