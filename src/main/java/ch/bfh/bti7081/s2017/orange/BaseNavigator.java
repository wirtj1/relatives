package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.presenter.BasePresenter;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

/**
 * Created by Leandro on 9/5/2017.
 */
public abstract class BaseNavigator extends Navigator {
    public BaseNavigator(UI ui, ComponentContainer container)
    {
        super(ui, container);
    }
    public abstract void addView(BasePresenter presenter, boolean addToMenu);
    public abstract <T extends BaseView> void navigateTo(Class<T> destinationView, ParameterSet parameterSet);
    public abstract <T extends BaseView> void navigateTo(Class<T> destinationView);

}
