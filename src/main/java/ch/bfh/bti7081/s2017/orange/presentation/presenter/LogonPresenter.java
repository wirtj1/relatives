package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.LogonModel;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.ILogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.LogonView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinboardView;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.Page;
import com.vaadin.shared.Position;
import com.vaadin.ui.Notification;

/**
 * Logon Presenter
 *
 * @author Sascha
 */
public class LogonPresenter extends BasePresenter<LogonView, LogonModel> implements ILogonView.ILogonViewListener
{
    public LogonPresenter(LogonView view, LogonModel model)
    {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void doLogin(String user, String password)
    {
        Session session = Session.logon(user, password);
        if (session == null)
        {
            Notification errorMessage = new Notification("Logon failed", "Username / Password combination is not valid", Notification.Type.ERROR_MESSAGE);
            errorMessage.setPosition(Position.TOP_CENTER);
            errorMessage.setIcon(VaadinIcons.EXCLAMATION_CIRCLE_O);
            errorMessage.show(Page.getCurrent());
            return;
        }

        view.closeWindow();

        view.getUI().getSession().setAttribute(Session.class, session);
        view.getUI().getNavigator().navigateTo(PinboardView.class);
    }
}
