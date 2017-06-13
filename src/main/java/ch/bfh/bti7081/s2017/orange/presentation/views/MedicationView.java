package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationView extends BaseView implements IMedicationView {

    private List<IMedicationViewListener> listeners;

    private Accordion medications;



    public MedicationView(){
        listeners = new ArrayList<>();

        medications = new Accordion();

        VerticalLayout layout = new VerticalLayout();
        layout.addComponent(medications);

        setViewTitle(layout);
        setCompositionRoot(layout);
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

    public void addMedication(MedicationModel model){

        VerticalLayout tab = new VerticalLayout();
        tab.addComponents(new Label(model.getDose()), new Label(model.getInterval() + "x daily"), new Label(model.getDescription()));

        medications.addTab(tab, model.getMedicine(), VaadinIcons.PILL);
    }

    public void clearMedications() {
        medications.removeAllComponents();
    }
}
