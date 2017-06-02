package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.MedicationModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import com.vaadin.navigator.View;

import java.util.Set;

/**
 * Created by Sascha on 15/05/2017.
 */
public interface IMedicationView extends View {

    interface IMedicationViewListener{
        void onViewEnter(ParameterSet parameter);
    }

    void addListener(IMedicationViewListener listener);

}
