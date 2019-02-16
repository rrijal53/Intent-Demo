package com.rowsun.myapplication.model;

import java.util.List;

public class NewsResponse {
   private String status;
   private List<News> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<News> getData() {
        return data;
    }

    public void setData(List<News> data) {
        this.data = data;
    }
}
