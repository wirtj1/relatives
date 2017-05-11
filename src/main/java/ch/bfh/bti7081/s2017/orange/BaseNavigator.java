package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.presenter.BasePresenter;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

/**
 * Base class for Vaadin Navigator
 * @author Leandro
 */
public abstract class BaseNavigator extends Navigator {
    public BaseNavigator(UI ui, ComponentContainer container)
    {
        super(ui, container);
    }
    public abstract void addView(BasePresenter presenter, boolean addToMenu);
    public abstract <T extends BaseView> void navigateTo(Class<T> destinationView, ParameterSet parameterSet);
    public abstract <T extends BaseView> void navigateTo(Class<T> destinationView);

    @Override
    public BaseUI getUI() {
        return (BaseUI) super.getUI();
    }
}
