package ch.bfh.bti7081.s2017.orange.presentation.views.components;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Professional;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import com.vaadin.data.Binder;

/**
 * Component for showing the Relative
 * @author Joy Wirth
 */
public class RelativeGrid extends PersonGrid {


    public RelativeGrid(Relative relative) {
        super(relative);
        Binder<Relative> binder = getBinder();
        binder.readBean(relative);
        //TODO wijo add to grid

    }

    //TODO wijo override methods
}
