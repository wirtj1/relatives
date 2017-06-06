package ch.bfh.bti7081.s2017.orange.presentation.presenter.states;

import ch.bfh.bti7081.s2017.orange.presentation.presenter.BaseContextPresenter;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;

/**
 * @author Leandro
 */
public class BasePresenterState <TPresenter extends BaseContextPresenter> implements BaseView.IBaseViewListener {
    private final TPresenter presenter;

    public BasePresenterState(TPresenter baseContextPresenter)
    {
        this.presenter = baseContextPresenter;
    }


    public TPresenter getPresenter() {
        return presenter;
    }
}
