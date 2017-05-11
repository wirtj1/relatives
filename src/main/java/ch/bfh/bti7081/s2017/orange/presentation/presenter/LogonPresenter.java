package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.MvpNavigator;
import ch.bfh.bti7081.s2017.orange.businesslogic.models.LogonModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.ILogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.MainView;

/**
 * Logon Presenter
 * @author Sascha
 */
public class LogonPresenter extends BasePresenter<LogonView, LogonModel> implements ILogonView.ILogonViewListener {

    public LogonPresenter(LogonView view, LogonModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void doLogin(String user, String password) {
        if (user.equals("") && password.equals("")){
            Session session = new Session(user);
            view.getUI().getSession().setAttribute(Session.class, session);

            view.getUI().getNavigator().navigateTo(MainView.class);
        }
    }
}
