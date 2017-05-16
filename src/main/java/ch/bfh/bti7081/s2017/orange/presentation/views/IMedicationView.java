package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.View;

/**
 * Created by Sascha on 15/05/2017.
 */
public interface IMedicationView extends View {

    interface IMedicationViewListener{
        void onViewEnter(ParameterSet parameter);
        void onMedicineClick();
    }

    void addListener(IMedicationViewListener listener);

}
