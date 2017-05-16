package ch.bfh.bti7081.s2017.orange.presentation.views;

import ch.bfh.bti7081.s2017.orange.BaseUI;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.BaseModel;
import com.vaadin.data.Binder;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.UI;
import javafx.scene.input.TransferMode;

/**
 * @author Sascha
 * @author Leandro
 */
public abstract class BaseView extends CustomComponent implements IBaseView {

    public abstract String getViewName();
    public abstract String getCaption();

    @Override
    public BaseUI getUI() {
        return (BaseUI) super.getUI();
    }
}
