package ch.bfh.bti7081.s2017.orange;

import ch.bfh.bti7081.s2017.orange.presentation.utils.NavigationUtils;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.presenter.BasePresenter;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.UI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sascha on 05/05/2017.
 */
public class MvpNavigator extends BaseNavigator {

    private MenuBar navigationBar;
    private List<BaseView> views = new ArrayList<>();


    public MvpNavigator(BaseUI ui, ComponentContainer container, MenuBar navigation)
    {
        super(ui, container);
        this.navigationBar = navigation;
    }


    public void addView(BasePresenter presenter, boolean addToMenu) {
        addView(presenter.view.getViewName(), presenter.view);
        views.add(presenter.view);

        if (addToMenu)
        {
            navigationBar.addItem(presenter.view.getCaption(), null, menuItem -> navigateTo(presenter.view.getClass()));
        }

    }

    public <T extends BaseView> void navigateTo(Class<T> destinationView, ParameterSet parameterSet)
    {
        // Navigation to logon view is always possible
        if (getUI().sessionRegistered() || destinationView.equals(LogonView.class)){
            views.stream()
                    .filter(components -> components.getClass().equals(destinationView))
                    .findFirst()
                    .ifPresent(components -> navigateTo(NavigationUtils.combineNameAndParams(components.getViewName(), parameterSet)));
        }
    }


    public <T extends BaseView> void navigateTo(Class<T> destinationView)
    {
        navigateTo(destinationView, null);
    }
}
