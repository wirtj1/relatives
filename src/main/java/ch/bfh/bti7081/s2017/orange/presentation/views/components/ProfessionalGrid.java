package ch.bfh.bti7081.s2017.orange.presentation.views.components;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Professional;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Role;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;

import java.util.Arrays;

/**
 * Component for showing the Professional
 * @author Joy Wirth
 */
public class ProfessionalGrid extends PersonGrid {

    private ComboBox<Role> role = new ComboBox<>("Rolle");
    private Label onEmergency = new Label("Notfallkontakt / Pikett");



    public ProfessionalGrid(Professional professional) {
        super(professional);

        super.setButtonsInvisible();
        setAccordionTitle(professional.getName());
        setAccordionIcon(VaadinIcons.PLUS_SQUARE_LEFT_O);

        Binder<Professional> binder = getBinder();
        binder.bind(role, Professional::getRole, Professional::setRole);
        role.setItems(Arrays.asList(Role.values()));
        onEmergency.setVisible(professional.isOnEmergency());
        getGrid().addComponent(role);
        getGrid().addComponent(onEmergency);
        binder.readBean(professional);
    }

    @Override
    public void setToEditMode() {
        //noop Professionals can not be edited
        super.setButtonsInvisible();
    }


    @Override
    public void setToViewMode() {
        super.setToViewMode();
        role.setVisible(true);
        role.setEnabled(false);
        super.setButtonsInvisible();

    }

    public ComboBox<Role> getRole() {
        return role;
    }

    public Label getOnEmergency() {
        return onEmergency;
    }

}
