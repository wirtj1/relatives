package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.PinboardModel;
import ch.bfh.bti7081.s2017.orange.persistence.entity.PinBoard;
import ch.bfh.bti7081.s2017.orange.persistence.repository.impl.PinboardRepository;
import ch.bfh.bti7081.s2017.orange.presentation.views.IPinboardView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinCreationView;
import ch.bfh.bti7081.s2017.orange.presentation.views.PinboardView;

/**
 * Created by Jasmin on 16.05.2017.
 */
public class PinboardPresenter extends BasePresenter<PinboardView, PinboardModel>
        implements IPinboardView.IPinboardViewListener {

    private PinboardRepository pinboardRepo = new PinboardRepository(PinBoard.class);


    public PinboardPresenter(PinboardView view, PinboardModel model) {
        super(view, model);
        view.addListener(this);
    }

    @Override
    public void navigateToAddPinEntry() {
        view.getUI().getNavigator().navigateTo(PinCreationView.class);
    }

    @Override
    public void onViewEnter() {
        PinboardModel pinboardModel = new PinboardModel();
        pinboardModel.setPinboard(pinboardRepo.getAllTest());

        view.setPinboardModel(pinboardModel);
    }

}
