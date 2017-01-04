package com.nawin.todo_mvp;

/**
 * Created by brain on 1/4/17.
 */

public class BaseResponse<T> {
    private int status;
    private String statusMessage;
    private T data;
}
