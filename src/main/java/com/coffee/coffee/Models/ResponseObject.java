package com.coffee.coffee.Models;

public class ResponseObject {

    private Integer status;
    private String messages;
    private Object data;

    public ResponseObject(Integer status, String messages, Object data) {
        this.status = status;
        this.messages = messages;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
