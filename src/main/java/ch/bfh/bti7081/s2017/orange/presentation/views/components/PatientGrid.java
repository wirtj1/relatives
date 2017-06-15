package ch.bfh.bti7081.s2017.orange.presentation.views.components;

import ch.bfh.bti7081.s2017.orange.persistence.entity.Patient;
import com.vaadin.data.Binder;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;


/**
 * Component for showing the Patient
 * @author Joy Wirth
 */
public class PatientGrid extends PersonGrid {


	private TextField oasi = new TextField("AHV-Nummer", "");
	private TextArea goals = new TextArea("Ziele", "");
	private TextArea weekendInformation = new TextArea("Wochenend Informationen", "");
	private TextArea yearPlanning = new TextArea("Jahresplanung", "");

	public PatientGrid(Patient patient) {
		super(patient);
		setAccordionTitle(patient.getName());
		setAccordionIcon(VaadinIcons.USER_HEART);
		Binder<Patient> binder = getBinder();
		binder.forField(oasi)
				.asRequired("Darf nicht leer sein")
				.withValidator(v -> v.length() >= 15, "Muss mindestens 15 Zeichen sein (756.1234.5678.9)")
				.bind(Patient::getOasi, Patient::setOasi);
		binder.bind(goals, Patient::getGoals, Patient::setOasi);
		binder.bind(weekendInformation, Patient::getWeekendInformation, Patient::setWeekendInformation);
		binder.bind(yearPlanning, Patient::getYearPlanning, Patient::setYearPlanning);
		super.getGrid().addComponent(oasi);
		super.getGrid().addComponent(goals);
		super.getGrid().addComponent(weekendInformation);
		super.getGrid().addComponent(yearPlanning);
		binder.readBean(patient);
	}

	@Override
	public void setToEditMode() {
		super.setToEditMode();
		oasi.setEnabled(true);
		goals.setEnabled(true);
		weekendInformation.setEnabled(true);
		yearPlanning.setEnabled(true);
	}

	@Override
	public void setToViewMode() {
		super.setToViewMode();
		oasi.setEnabled(false);
		goals.setEnabled(false);
		weekendInformation.setEnabled(false);
		yearPlanning.setEnabled(false);
	}

	public TextField getOasi() {
		return oasi;
	}

	public TextArea getGoals() {
		return goals;
	}

	public TextArea getWeekendInformation() {
		return weekendInformation;
	}

	public TextArea getYearPlanning() {
		return yearPlanning;
	}
}
