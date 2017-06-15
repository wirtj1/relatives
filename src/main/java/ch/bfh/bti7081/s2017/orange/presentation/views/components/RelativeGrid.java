package ch.bfh.bti7081.s2017.orange.presentation.views.components;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Relative;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;

/**
 * Component for showing the Relative
 * @author Joy Wirth
 */
public class RelativeGrid extends PersonGrid {


    public RelativeGrid(Relative relative) {
        super(relative);
        setAccordionTitle(relative.getName());
        setAccordionIcon(VaadinIcons.FAMILY);
        Binder<Relative> binder = getBinder();
        binder.readBean(relative);

    }

}
