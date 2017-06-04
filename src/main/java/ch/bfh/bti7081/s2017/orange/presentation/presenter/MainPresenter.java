package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.BaseNavigator;
import ch.bfh.bti7081.s2017.orange.MvpNavigator;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.MainModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.ParameterSet;
import ch.bfh.bti7081.s2017.orange.presentation.views.IMainView;

import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;
import ch.bfh.bti7081.s2017.orange.presentation.views.TestView;
import com.vaadin.navigator.Navigator;

/**
 * Dummy Main Presenter
 */
public class MainPresenter extends BasePresenter<MainView, MainModel> implements IMainView.IMainViewListener  {


    public MainPresenter(MainView view, MainModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void logout(BaseNavigator navigator) {
        // Do logout
        model.setUserName("");
        view.setUsername(model.getUserName());

        //start Detail View
        //navigator.navigateTo("Test/fromMainView");
        ParameterSet parameterSet = new ParameterSet();
        parameterSet.addParameter("message", "helloFromMainView");
        navigator.navigateTo(TestView.class, parameterSet);

    }
}
