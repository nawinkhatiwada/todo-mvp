package com.nawin.todo_mvp;

/**
 * Created by brain on 12/26/16.
 */

/**
 * provides presenter to view
 */

public interface BaseView<T> {

    void setPresenter(T presenter);

}
