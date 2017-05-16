package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Resource;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 15/05/2017.
 */
public class MedicationView extends BaseView implements IMedicationView {

    private List<IMedicationViewListener> listeners;

    private Button medicine;
    private TextField interval;
    private TextField dose;
    private TextField description;



    public MedicationView(){
        listeners = new ArrayList<>();
        medicine = new Button("Medicin");
        medicine.addClickListener(this::onMedicineClick);
        interval = new TextField("Interval");
        interval.setReadOnly(true);
        dose = new TextField("Dose");
        dose.setReadOnly(true);
        description = new TextField("Description");
        description.setReadOnly(true);


        VerticalLayout innerContainer = new VerticalLayout();

        innerContainer.addComponent(medicine);
        innerContainer.addComponent(interval);
        innerContainer.addComponent(dose);
        innerContainer.addComponent(description);

        VerticalLayout outerContainer = new VerticalLayout();
        outerContainer.addComponent(innerContainer);
        outerContainer.setComponentAlignment(innerContainer, Alignment.MIDDLE_CENTER);

        setCompositionRoot(outerContainer);
    }

    private void onMedicineClick(Button.ClickEvent event){
        for (IMedicationViewListener listener : listeners){
            listener.onMedicineClick();
        }
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
}
