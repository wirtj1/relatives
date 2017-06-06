package ch.bfh.bti7081.s2017.orange.presentation.presenter;

import ch.bfh.bti7081.s2017.orange.businesslogic.models.BaseModel;
import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;

/**
 * @author Leandro
 */
public abstract class BaseContextPresenter
        <TView extends BaseView, TModel extends BaseModel, TState extends BaseView.IBaseViewListener>
        extends BasePresenter<TView, TModel> {

    TState state;

    BaseContextPresenter(TView view, TModel model){
        super(view, model);
    }

    public TState getState() {
        return state;
    }

    public void setState(TState state) {
        this.state = state;
    }
}
