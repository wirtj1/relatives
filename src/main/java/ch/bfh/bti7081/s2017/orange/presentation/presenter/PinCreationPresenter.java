package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.Person;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoardEntry;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PinboardRepository;
import ch.bfh.bti7081.s2017.orange.presentation.utils.Session;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinCreationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinboardView;

/**
 * Created by NTHEVJ on 28.05.2017.
 */
public class PinCreationPresenter extends BasePresenter<PinCreationView, PinboardModel>
        implements IPinboardView.IPinCreationViewListener
{
    private PinboardRepository pinboardRepo = new PinboardRepository(PinBoard.class);


    public PinCreationPresenter(PinCreationView view, PinboardModel model)
    {
        super(view, model);
        this.view.addListener(this);
    }


    @Override
    public void createPinEntry(PinBoardEntry entry)
    {
        Person currentUser
                = view.getUI().getSession().getAttribute(Session.class).getPerson();

        entry.setAuthor(currentUser);
        model.addEntry(entry);
        
        pinboardRepo.persist(model.getPinboard());
        view.getUI().getNavigator().navigateTo(PinboardView.class);
    }

    @Override
    public void onViewEnter()
    {
        Person user = view.getUI().getSession().getAttribute(Session.class).getPerson();
        view.setAuthorName(user.getFirstName() + " " + user.getLastName());
    }
}
