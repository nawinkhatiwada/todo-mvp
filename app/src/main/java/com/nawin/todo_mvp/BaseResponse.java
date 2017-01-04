package com.nawin.todo_mvp;

/**
 * Created by brain on 1/4/17.
 */

public class BaseResponse<T> {
    private int status;
    private String statusMessage;
    private T data;


    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
