package com.rowsun.myapplication.model;

import java.util.List;

public class PersonResponse
{
    private List<Persons> data;

    private String success;

    private String message;

    public List<Persons> getData() {
        return data;
    }

    public void setData(List<Persons> data) {
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}