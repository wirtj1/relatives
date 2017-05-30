package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationListModel;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationView extends BaseView implements IMedicationView {

    private List<IMedicationViewListener> listeners;

    private TextField medicine;
    private TextField interval;
    private TextField dose;
    private TextField description;
    private ListSelect<MedicationModel> medications;



    public MedicationView(){
        listeners = new ArrayList<>();

        GridLayout grid = new GridLayout(3, 4);
        grid.setSizeFull();

        // MedicationList
        medications = new ListSelect<>();
        medications.addValueChangeListener(valueChangeEvent -> {
            for (IMedicationViewListener listener : listeners){
                listener.onMedicineClick(valueChangeEvent.getValue().stream().findFirst().get());
            }
        });
        grid.addComponent(medications, 0,0,0,3);

        // Medicine
        medicine = new TextField();
        medicine.setReadOnly(true);
        medicine.setStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        grid.addComponent(new Label("Medicine"), 1, 0);
        grid.addComponent(medicine, 2, 0);

        // Interval
        interval = new TextField();
        interval.setReadOnly(true);
        interval.setStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        grid.addComponent(new Label("Interval"), 1, 1);
        grid.addComponent(interval, 2, 1);

        // Dose
        dose = new TextField("Dose");
        dose.setReadOnly(true);
        dose.setStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        grid.addComponent(new Label("Dose"), 1, 2);
        grid.addComponent(dose, 2, 2);

        // Description
        description = new TextField("Description");
        description.setReadOnly(true);
        description.setStyleName(ValoTheme.TEXTFIELD_BORDERLESS);

        grid.addComponent(new Label("Description"), 1, 3);
        grid.addComponent(description, 2, 3);


        // Create inner container for correct placement
        VerticalLayout innerContainer = new VerticalLayout();

        innerContainer.addComponent(grid);
        innerContainer.setComponentAlignment(grid, Alignment.MIDDLE_CENTER);

        VerticalLayout outerContainer = new VerticalLayout();
        outerContainer.addComponent(innerContainer);
        outerContainer.setComponentAlignment(innerContainer, Alignment.MIDDLE_CENTER);

        setCompositionRoot(outerContainer);
    }

    @Override
    public void addListener(IMedicationViewListener listener) {
        listeners.add(listener);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {
        ParameterSet parameter = ParameterSet.decode(viewChangeEvent.getParameters());
        for (IMedicationViewListener listener : listeners){
            listener.onViewEnter(parameter);
        }
    }

    @Override
    public String getViewName() {
        return "Medication";
    }

    @Override
    public String getCaption() {
        return "Medication";
    }

    public void setMedications(MedicationListModel model){
        medications.setItems(model.getMedications());
    }

    public void setCurrentMedication(MedicationModel model){
        medicine.setValue(model.getMedicine());
        dose.setValue(model.getDose());
        description.setValue(model.getDescription());
        interval.setValue(model.getInterval());
    }
}
