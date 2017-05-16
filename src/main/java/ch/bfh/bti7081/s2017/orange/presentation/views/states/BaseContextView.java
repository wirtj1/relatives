package ch.bfh.bti7081.s2017.orange.presentation.views.states;

import ch.bfh.bti7081.s2017.orange.presentation.views.BaseView;

/**
 * Created by Leandro on 12/5/2017.
 */
public abstract class BaseContextView<T extends BaseViewState> extends BaseView {
    T viewState;

    public T getViewState() {
        return viewState;
    }

    public void setViewState(T viewState) {
        this.viewState = viewState;
    }
}
